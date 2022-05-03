package com.ebook.apply.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ebook.apply.model.Apply;

@Repository
public interface ApplyDAO {
	public int insertApply(
			@Param("userId")int userId, 
			@Param("bookName")String bookName, 
			@Param("bookAuthor")String bookAuthor, 
			@Param("bookPublisher")String bookPublisher, 
			@Param("bookPublishYear")Date bookPublishDate);
	public List<Apply> selectApplyList();
	public int deleteApply(
			@Param("id")int id, 
			@Param("userId")int userId);
	public Apply selectApplyById(int id);
}
