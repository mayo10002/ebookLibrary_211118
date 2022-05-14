package com.ebook.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebook.book.bo.BookBO;

@RequestMapping("/admin")
@Controller
public class AdminController {
	@Autowired
	private BookBO bookBO; 
	
	
}
