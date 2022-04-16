package com.ebook.searchInfo.model;

import com.ebook.book.model.Book;
import com.ebook.borrow.model.Borrow;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchBookView {
	private Book book;
	private boolean filledBookmark;
	
}
