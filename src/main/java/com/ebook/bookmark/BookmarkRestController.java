package com.ebook.bookmark;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.bookmark.bo.BookmarkBO;

@RequestMapping("/bookmark")
@RestController
public class BookmarkRestController {
	@Autowired
	private BookmarkBO bookmarkBO;
	
	@RequestMapping("/{bookId}")
	public Map<String, Object> bookmark(
			@PathVariable int bookId,
			HttpSession session){
		Map<String, Object> result = new HashMap<>();
		
		Integer userId = (Integer)session.getAttribute("userId");
		
		// Insert DB
		bookmarkBO.addBookmark(userId, bookId);
		
		if (userId == null) {
			result.put("result", "error");
			result.put("error_message", "로그인이 되어있지 않습니다.");
		}
		result.put("result", "success");
		return result;
		
	}
}
