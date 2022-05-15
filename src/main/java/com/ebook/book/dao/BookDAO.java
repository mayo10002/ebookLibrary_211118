package com.ebook.book.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	public int insertBookByAdmin (
			@Param("name")String name, 
			@Param("author")String author, 
			@Param("publisher")String publisher, 
			@Param("publishDate")Date publishDate ,
			@Param("imagePath")String imagePath, 
			@Param("isbn")String isbn, 
			@Param("page")Integer page, 
			@Param("info")String info, 
			@Param("categoryId")int categoryId
			);
}
