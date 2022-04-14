package com.ebook.searchInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/search")
@Controller
public class SearchInfoController {
	@RequestMapping("/search_list_view")
	public String searchListView(Model model) {
		model.addAttribute("viewName","book/search");
		return "template/layout";
	}
}
