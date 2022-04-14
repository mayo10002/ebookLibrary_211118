package com.ebook.borrow.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Borrow {
	private int id;
	private int userId;
	private int bookId;
	private Date borrowAt;
	private Date returnAt;
	private Date createdAt;
	private Date updatedAt;
}
