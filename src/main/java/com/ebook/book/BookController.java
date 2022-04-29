package com.ebook.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebook.book.bo.BookBO;
import com.ebook.book.model.Book;

@RequestMapping("/book")
@Controller
public class BookController {
	@Autowired
	private BookBO bookBO;
	@RequestMapping("/main_view")
	public String mainView(Model model) {
		List<Book> latestBook = bookBO.getLatestBookList();
		model.addAttribute("latestBook",latestBook);
		model.addAttribute("viewName","book/main");
		return "template/layout";
	}
	
	
}
