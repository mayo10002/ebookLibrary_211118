package com.ebook.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ebook.user.model.User;

@Repository
public interface UserDAO {
	public User selectUser(int id);
	public boolean existUserByLoginId(String loginId);
	public int insertUser(
			@Param("loginId")String loginId, 
			@Param("password")String password, 
			@Param("name")String name, 
			@Param("phoneNumber")String phoneNumber);
	
	public User selectUserByLoginIdAndPassword(
			@Param("loginId")String loginId, 
			@Param("password")String password);
	public void updateUserByUserId(
			@Param("id")int id, 
			@Param("loginId")String loginId,
			@Param("name")String name,
			@Param("phoneNumber")String phoneNumber);
}
