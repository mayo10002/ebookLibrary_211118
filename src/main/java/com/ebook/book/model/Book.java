package com.ebook.book.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Book {
	private int id;
	private String name;
	private String author;
	private String publisher;
	private Date publishDate;
	private String imagePath;
	private String isbn;
	private int page;
	private String state;
	private String info;
	private int categoryId;
	private Date createdAt;
	private Date updatedAt;
	
}
