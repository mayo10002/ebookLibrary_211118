package com.ebook.book.bo;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ebook.book.dao.BookDAO;
import com.ebook.book.model.Book;
import com.ebook.borrow.bo.BorrowBO;
import com.ebook.common.FileManagerService;

@Service
public class BookBO {
	@Autowired
	private BookDAO bookDAO;
	@Autowired
	private BorrowBO borrowBO;
	@Autowired 
	private FileManagerService fileManagerService;
	
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
	public int addBookByAdmin(String loginId, String name, String author, String publisher, Date publishDate ,
			MultipartFile file, String isbn, Integer page, String info, int categoryId) {
		String imagePath = null;
		if(file != null) {
		try {
			imagePath = fileManagerService.saveFile(loginId, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		return bookDAO.insertBookByAdmin(name, author, publisher, publishDate, imagePath, isbn, page, info, categoryId);
	}
}
