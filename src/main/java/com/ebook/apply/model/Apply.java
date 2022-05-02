package com.ebook.apply.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Apply {
	private int id;
	private int userId;
	private String bookName;
	private String bookAuthor;
	private String bookPublisher;
	private Date bookPublishDate;
	private Date createdAt;
}
