package com.ebook.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.EncryptUtils;
import com.ebook.user.bo.UserBO;
import com.ebook.user.model.User;

@RequestMapping("/user")
@RestController
public class UserRestController {
	@Autowired
	private UserBO userBO;
	@RequestMapping("/is_duplicated_id")
	public Map<String, Boolean> isDuplicatedId(
			@RequestParam("loginId") String loginId,
			HttpServletRequest request){
		
		Map<String, Boolean> result = new HashMap<>();
		HttpSession session = request.getSession();
		//로그인 상태일 시 회원 정보를 수정할 때 중복확인에서 자신의 아이디는 중복되어도 괜찮다.
		if(session != null) {
			String userLoginId = (String)session.getAttribute("userLoginId");
			
			if(loginId.equals(userLoginId)) {
				result.put("result", false);
			}else {
				result.put("result", userBO.existUserByLoginId(loginId));
			}
		
		}else {
			result.put("result", userBO.existUserByLoginId(loginId));
		}
		return result;
	} 
	@PostMapping("/sign_up")
	public Map<String, Object> signUp(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber){
		String encryptPassword = EncryptUtils.md5(password);
		// insert DB
		int row = userBO.addUser(loginId, encryptPassword, name, phoneNumber);
		// Response
		Map<String, Object> result = new HashMap<>();
		
		if( row < 1 ) {
			result.put("result", "error");
			result.put("error_message","회원가입에 실패했습니다.");
		}else {
			result.put("result", "success");
		}
		
		return result;
	}
	
	//로그인
	@PostMapping("/sign_in")
	public Map<String, Object> signIn(
			@RequestParam("loginId")String loginId,
			@RequestParam("password")String password,
			HttpServletRequest request){
		String encryptPassword = EncryptUtils.md5(password);
		
		Map<String, Object> result = new HashMap<>();
		
		User user = userBO.getUserByLoginIdAndPassword(loginId, encryptPassword);
		if(user != null) {
			result.put("result", "success");
					
			HttpSession session = request.getSession();			
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			session.setAttribute("userName", user.getName());
			session.setAttribute("userPhoneNumber", user.getPhoneNumber());
		}else {
			result.put("result", "error");
			result.put("error_message", "존재하지 않는 사용자입니다.");
		}
		
		return result;
	}

	@RequestMapping("/update_user")
	public Map<String, Object> updateUser(
			@RequestParam("loginId")String loginId,
			@RequestParam("password") String password,
			@RequestParam("name")String name,
			@RequestParam("phoneNumber")String phoneNumber,
			HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String, Object> result = new HashMap<>();
		String encryptPassword = EncryptUtils.md5(password);
		int userId = (int)session.getAttribute("userId");
		if( userBO.confirmPasswordByUserId(userId, encryptPassword) == true) {
			userBO.editUserByUserId(userId, loginId, name, phoneNumber);
			result.put("result", "success");
		}else {
			result.put("result","error");
			result.put("error_message", "비밀번호가 일치하지 않습니다.");
		}
		return result;
	}

}
