package com.ebook.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/book")
@Controller
public class BookController {
	@RequestMapping("/main_view")
	public String mainView(Model model) {
		model.addAttribute("viewName","book/main");
		return "template/layout";
	}
	
	@RequestMapping("/search_list_view")
	public String searchListView(Model model) {
		model.addAttribute("viewName","book/search");
		return "template/layout";
	}
}
