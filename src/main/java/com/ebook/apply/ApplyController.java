package com.ebook.apply;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ebook.apply.bo.ApplyBO;
import com.ebook.apply.model.Apply;
import com.ebook.apply.model.DetailView;
import com.ebook.user.bo.UserBO;
import com.ebook.user.model.User;

@RequestMapping("/apply")
@Controller
public class ApplyController {
	@Autowired
	private ApplyBO applyBO;
	@Autowired
	private UserBO userBO;
	/**
	 * 희망 도서 신청
	 * @param model
	 * @return
	 */
	@RequestMapping("/apply_create_view")
	public String createApplyView(
			Model model) {
		model.addAttribute("viewName","apply/apply_create");
		return "template/layout";
		
	}
	/**
	 * 희망 도서 신청 목록
	 * @param model
	 * @return
	 */
	@RequestMapping("/apply_list_view")
	public String listApplyView(
			Model model) {
		List<DetailView> applyList = applyBO.generateListView();
		model.addAttribute("applyList",applyList);
		
 		model.addAttribute("viewName","apply/apply_list");
		return "template/layout";
	}
	@RequestMapping("/apply_detail_view/{applyId}")
	public String detailApplyView(
			@PathVariable("applyId") int applyId,
			Model model) {
		DetailView detailview = applyBO.generateDetailViewById(applyId);
		model.addAttribute("detailview",detailview);
		model.addAttribute("viewName","apply/apply_detail");
		return "template/layout";
	}
}
