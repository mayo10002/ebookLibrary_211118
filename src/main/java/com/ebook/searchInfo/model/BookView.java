package com.ebook.searchInfo.model;

import com.ebook.book.model.Book;
import com.ebook.borrow.model.Borrow;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookView {
	private Book book;
	private Borrow borrow;

	//아마 bookInfo로 쓸 것 같다. bookmark 추후 추가
	
}
