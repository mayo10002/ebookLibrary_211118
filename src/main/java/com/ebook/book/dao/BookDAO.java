package com.ebook.book.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ebook.book.model.Book;

@Repository
public interface BookDAO {
	public List<Book> selectBookBySearchText(String searchText);
	public Book selectBookByBookId(Integer id); 
	public void updateStateToBorrowByBookId(int id);
	public void updateStateToReserveByBookId(int id);
	public List<Book> selectLatestBookList();
	public List<Book> selectRecommendBookList(int categoryId);
}
