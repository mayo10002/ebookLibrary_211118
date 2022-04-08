package com.ebook.user.dao;

import org.springframework.stereotype.Repository;

import com.ebook.user.model.User;

@Repository
public interface UserDAO {
	public User selectUser(int id);
}
