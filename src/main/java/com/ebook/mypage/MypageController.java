package com.ebook.mypage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebook.mypage.bo.MypageViewBO;
import com.ebook.mypage.model.BookView;
@RequestMapping("/mypage")
@Controller
public class MypageController {
	@Autowired
	private MypageViewBO mypageViewBO;
	@RequestMapping("/{userId}")
	public String borrowView(
			@PathVariable int userId,
			Model model,
			HttpSession session) {
		
		userId = (int)session.getAttribute("userId");
		List<BookView> borrowViewList = mypageViewBO.generateBorrowViewList(userId);
		List<BookView> reserveViewList = mypageViewBO.generateReserveViewList(userId);
		List<BookView> bookmarkViewList = mypageViewBO.generateBookmarkViewList(userId);
		model.addAttribute("borrowViewList",borrowViewList);
		model.addAttribute("reserveViewList",reserveViewList);
		model.addAttribute("bookmarkViewList",bookmarkViewList);
		model.addAttribute("viewName","user/mypage");
		return "template/layout";
		
	}
}
