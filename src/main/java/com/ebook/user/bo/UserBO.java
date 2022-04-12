package com.ebook.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.user.dao.UserDAO;
import com.ebook.user.model.User;

@Service
public class UserBO {
	@Autowired
	private UserDAO userDAO;
	
	public User getUser(int userId) {
		return userDAO.selectUser(userId);
	}
	public boolean existUserByLoginId(String loginId) {
		return userDAO.existUserByLoginId(loginId);
	}
	public int addUser(String loginId, String password, String name, String phoneNumber) {
		return userDAO.insertUser(loginId, password, name, phoneNumber);
	}
	public User getUserByLoginIdAndPassword(String loginId, String password) {
		return userDAO.selectUserByLoginIdAndPassword(loginId, password);
	}
	public boolean confirmPasswordByUserId(int userId, String password) {
		if (password == userDAO.selectUser(userId).getPassword()) {
			return true;
		}else {
			return false;
		}
	}
	public void editUserByUserId(int userId, String loginId, String name, String phoneNumber) {
		userDAO.updateUserByUserId(userId, loginId, name, phoneNumber);
	}
}
