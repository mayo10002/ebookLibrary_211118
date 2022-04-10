package com.ebook.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.common.EncryptUtils;
import com.ebook.user.bo.UserBO;

@RequestMapping("/user")
@RestController
public class UserRestController {
	@Autowired
	private UserBO userBO;
	@RequestMapping("/is_duplicated_id")
	public Map<String, Boolean> isDuplicatedId(
			@RequestParam("loginId") String loginId){
		Map<String, Boolean> result = new HashMap<>();
		
		result.put("result", userBO.existUserByLoginId(loginId));
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
//	@PostMapping("/sign_in")
//	public Map<String, Object> signIn(){
//		
//	}
}
