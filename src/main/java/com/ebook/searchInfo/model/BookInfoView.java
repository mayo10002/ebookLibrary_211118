package com.ebook.searchInfo.model;

import java.util.Date;

import com.ebook.book.model.Book;
import com.ebook.borrow.model.Borrow;
import com.ebook.category.model.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookInfoView {
	private Book book;
	private boolean filledBookmark;
	private Category category;
	private Date returnInfo;
}
