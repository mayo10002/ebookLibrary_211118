package com.ebook.apply.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.apply.dao.ApplyDAO;
import com.ebook.apply.model.Apply;
import com.ebook.apply.model.DetailView;
import com.ebook.user.bo.UserBO;

@Service
public class ApplyBO {
	@Autowired
	private ApplyDAO applyDAO;
	@Autowired
	private UserBO userBO;
	public int addApply(int userId, String bookName, String bookAuthor, String bookPublisher, Date bookPublishDate) {
		return applyDAO.insertApply(userId, bookName, bookAuthor, bookPublisher, bookPublishDate);
	}
	public List<Apply> getApplyList(){
		return applyDAO.selectApplyList();
	}
	public int deleteApply(int id, int userId) {
		return applyDAO.deleteApply(id, userId);
	}
	public Apply getApplyById(int id) {
		return applyDAO.selectApplyById(id);
	}
	public List<DetailView> generateListView() {
		List<DetailView> applyListView = new ArrayList<>();
		
		List<Apply> applyList = getApplyList();
		for(Apply apply : applyList) {
			DetailView listview = new DetailView();
			listview.setUser(userBO.getUser(apply.getUserId()));
			listview.setApply(apply);
			applyListView.add(listview);
		}
		return applyListView;
	}
	public DetailView generateDetailViewById(int id) {
		DetailView detailview = new DetailView();
		detailview.setUser(userBO.getUser(getApplyById(id).getUserId()));
		detailview.setApply(getApplyById(id));
		return detailview;
	}
}
