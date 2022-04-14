package com.ebook.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.book.bo.BookBO;
import com.ebook.book.model.Book;

@RequestMapping("/book")
@RestController
public class BookRestController {
	//update
	@Autowired
	private BookBO bookBO;
	@RequestMapping("/search")
	public List<Book> searchBook(
			@RequestParam("searchText")String searchText){
		// 저쪽 searchViewBO에서 가져와서 이게 있으면 result success출력하기
		List<Book> searchBookResult = bookBO.getBookBySearchText(searchText);//searchInfoBO 에서 return값 받아내기
		
		//
	}
}
