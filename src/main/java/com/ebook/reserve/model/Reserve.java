package com.ebook.reserve.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reserve {
	private int id;
	private int userId;
	private int bookId;
	private Date createdAt;
}
