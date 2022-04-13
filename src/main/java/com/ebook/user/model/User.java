package com.ebook.user.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class User {
	private int id;
	private String loginId;
	private String password;
	private String name;
	private String phoneNumber;
	private Date createdAt;
	private Date updatedAt;
	
}
