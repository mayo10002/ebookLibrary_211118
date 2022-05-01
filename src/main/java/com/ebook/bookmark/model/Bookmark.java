package com.ebook.bookmark.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Bookmark {
	private int id;
	private int userId;
	private int bookId;
	private Date createdAt;
}
