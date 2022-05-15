package com.ebook.admin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ebook.book.bo.BookBO;

@RequestMapping("/admin")
@RestController
public class AdminRestController {
	@Autowired
	private BookBO bookBO;
	@PostMapping("/create")
	public Map<String, Object> createBook(
			@RequestParam("bookName")String bookName,
			@RequestParam("bookAuthor")String bookAuthor,
			@RequestParam("bookPublisher")String bookPublisher,
			@RequestParam("bookPublishDate")String bookPublishDate,
			@RequestParam("bookIsbn")String bookIsbn,
			@RequestParam("bookPage")String bookPage,
			@RequestParam("bookInfo")String bookInfo,
			@RequestParam("bookCategory")String bookCategory,
			@RequestParam(value="file", required=false) MultipartFile file,
			HttpSession session 
			) throws ParseException{
		Map<String, Object> result = new HashMap<>();
		
		String loginId = (String)session.getAttribute("userLoginId");
		if (loginId.equals("admin") == false) {
			result.put("result", "error");
			result.put("error_message", "관리자 권한이 아닙니다.");
			return result;
		}
		DateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
		Date bookPublishdate = dateFormat.parse(bookPublishDate);

		Integer bookpage = Integer.parseInt(bookPage);
		int bookcategory2 = Integer.parseInt(bookCategory);
		
		int row = bookBO.addBookByAdmin(loginId, bookName, bookAuthor, bookPublisher,
				bookPublishdate, file, bookIsbn, bookpage, bookInfo, bookcategory2);
		if(row < 1) {
			result.put("result", "error");
			result.put("error_message", "도서 추가에 실패했습니다.");
		}else {
			result.put("result", "success");
		}
		return result;
	}
	
}
