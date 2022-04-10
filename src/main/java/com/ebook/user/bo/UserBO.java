package com.ebook.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.user.dao.UserDAO;
import com.ebook.user.model.User;

@Service
public class UserBO {
	@Autowired
	private UserDAO userDAO;
	
	public User getUser(int id) {
		return userDAO.selectUser(id);
	}
	public boolean existUserByLoginId(String loginId) {
		return userDAO.existUserByLoginId(loginId);
	}
	public int addUser(String loginId, String password, String name, String phoneNumber) {
		return userDAO.insertUser(loginId, password, name, phoneNumber);
	}

}
