package com.ebook.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {
	@RequestMapping("/apply_insert_view")
	public String insertBookView(Model model) {
		
		model.addAttribute("viewName","admin/book_create");
		return "template/layout";
	}
	
}
