package com.ebook.book.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.book.dao.BookDAO;
import com.ebook.book.model.Book;
import com.ebook.borrow.bo.BorrowBO;

@Service
public class BookBO {
	@Autowired
	private BookDAO bookDAO;
	@Autowired
	private BorrowBO borrowBO;
	
	public List<Book> getBookBySearchText(String searchText){
		return bookDAO.selectBookBySearchText(searchText);
	}
	public Book getBookByBookId(Integer bookId) {
		return bookDAO.selectBookByBookId(bookId);
	}
	public void changeStateToBorrowByBookId(int bookId) {
		bookDAO.updateStateToBorrowByBookId(bookId);
	}
	public void changeStateToReserveByBookId(int bookId) {
		bookDAO.updateStateToReserveByBookId(bookId);
	}
	public List<Book> getLatestBookList(){
		return bookDAO.selectLatestBookList();
	}
	public List<Book> getRecommendBookList(int userId){
		if(getBookByBookId(borrowBO.getLatestBorrowBookId(userId)) == null) {
			return null;
		}else {
		int categoryId = getBookByBookId(borrowBO.getLatestBorrowBookId(userId)).getCategoryId();
		return bookDAO.selectRecommendBookList(categoryId);
		}
	}
}
