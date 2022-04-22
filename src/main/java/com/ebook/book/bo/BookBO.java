package com.ebook.book.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.book.dao.BookDAO;
import com.ebook.book.model.Book;

@Service
public class BookBO {
	@Autowired
	private BookDAO bookDAO;
	public List<Book> getBookBySearchText(String searchText){
		return bookDAO.selectBookBySearchText(searchText);
	}
	public Book getBookByBookId(int bookId) {
		return bookDAO.selectBookByBookId(bookId);
	}
	public void changeStateToBorrowByBookId(int bookId) {
		bookDAO.updateStateToBorrowByBookId(bookId);
	}
	public void changeStateToReserveByBookId(int bookId) {
		bookDAO.updateStateToReserveByBookId(bookId);
	}
}
