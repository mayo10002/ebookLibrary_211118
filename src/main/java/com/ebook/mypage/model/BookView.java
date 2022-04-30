package com.ebook.mypage.model;

import java.util.Date;

import com.ebook.book.model.Book;
import com.ebook.category.model.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookView {
	private Book book;
	private Category category;
	private Date returnInfo;
}
