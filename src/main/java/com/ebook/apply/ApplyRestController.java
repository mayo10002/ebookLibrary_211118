package com.ebook.apply;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.apply.bo.ApplyBO;
@RequestMapping("/apply")
@RestController
public class ApplyRestController {
	@Autowired
	private ApplyBO applyBO;
	
	@PostMapping("/create")
	public Map<String, Object> createApply(
			@RequestParam("bookName")String bookName,
			@RequestParam("bookAuthor")String bookAuthor,
			@RequestParam("bookPublisher")String bookPublisher,
			@RequestParam("bookPublishYear")Date bookPublishYear,
			HttpSession session){
		int userId = (int)session.getAttribute("userId");
		//insert DB
		Map<String, Object> result = new HashMap<>();
		int row = applyBO.addApply(userId, bookName, bookAuthor, bookPublisher, bookPublishYear);
		
		if( row < 1 ) {
			result.put("result", "error");
			result.put("error_message","희망 도서 신청에 실패했습니다.");
		}else {
			result.put("result", "success");
		}
		
		return result;
	}
	@DeleteMapping("/delete")
	public Map<String, Object> deleteApply(
			@RequestParam("applyId")int applyId, 
			HttpSession session){
		
	}
}
