package com.ebook.apply.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.apply.dao.ApplyDAO;
import com.ebook.apply.model.Apply;

@Service
public class ApplyBO {
	@Autowired
	private ApplyDAO applyDAO;
	public int addApply(int userId, String bookName, String bookAuthor, String bookPublisher, Date bookPublishYear) {
		return applyDAO.insertApply(userId, bookName, bookAuthor, bookPublisher, bookPublishYear);
	}
	public List<Apply> getApplyList(){
		return applyDAO.selectApplyList();
	}
	public int deleteApply(int id, int userId) {
		return applyDAO.deleteApply(id, userId);
	}
}
