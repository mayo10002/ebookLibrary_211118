package com.ebook.searchInfo;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ebook.searchInfo.bo.SearchViewBO;
import com.ebook.searchInfo.model.SearchBookView;

@RequestMapping("/search")
@Controller
public class SearchInfoController {
	@Autowired
	private SearchViewBO searchViewBO;
	@RequestMapping("/search_list_view")
	public String searchListView(
			@RequestParam("searchText")String searchText
			,Model model
			,HttpSession session) {
		
		Integer userId = (Integer)session.getAttribute("userId");
		
		List<SearchBookView> searchViewList = searchViewBO.generateSearchViewList(searchText, userId);
		model.addAttribute("searchViewList",searchViewList);
		model.addAttribute("viewName","book/search");
		return "template/layout";
	}
	
	
}
