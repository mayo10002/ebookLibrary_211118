package com.ebook.mypage.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.book.bo.BookBO;
import com.ebook.book.model.Book;
import com.ebook.bookmark.bo.BookmarkBO;
import com.ebook.bookmark.model.Bookmark;
import com.ebook.borrow.bo.BorrowBO;
import com.ebook.borrow.model.Borrow;
import com.ebook.category.bo.CategoryBO;
import com.ebook.mypage.model.BookView;
import com.ebook.reserve.bo.ReserveBO;
import com.ebook.reserve.model.Reserve;

@Service
public class MypageViewBO {
	@Autowired
	private BookBO bookBO;
	@Autowired
	private BorrowBO borrowBO;
	@Autowired
	private ReserveBO reserveBO;
	@Autowired
	private CategoryBO categoryBO;
	@Autowired
	private BookmarkBO bookmarkBO;
	public List<BookView> generateBorrowViewList(int userId){
		List<BookView> borrowViewList = new ArrayList<>();
		List<Book> borrowBookList = new ArrayList<>();
		
		// list에 있는 int값을 다시 변수로 넣어 list값을 뽑아내야 하므로 for문을 돌린다.
		for(Borrow borrow : borrowBO.getBorrowByUserId(userId)) {
			Book book = bookBO.getBookByBookId(borrow.getBookId());
			borrowBookList.add(book);
		}
		
		for(Book book : borrowBookList) {
			BookView borrow = new BookView();
			borrow.setBook(book);
			borrow.setCategory(categoryBO.getCategoryByCategoryId(book.getId()));
			borrow.setReturnInfo(borrowBO.getReturnAtByBookIdAndUserId(userId,book.getId()));
			borrowViewList.add(borrow);
		}
		return borrowViewList;
	}
	
	public List<BookView> generateReserveViewList(int userId){
		List<BookView> reserveViewList = new ArrayList<>();
		List<Book> reserveBookList = new ArrayList<>();
		
		// list에 있는 int값을 다시 변수로 넣어 list값을 뽑아내야 하므로 for문을 돌린다.
		for(Reserve reserve : reserveBO.getReserveListByUserId(userId)) {
			Book book = bookBO.getBookByBookId(reserve.getBookId());
			reserveBookList.add(book);
		}
		
		for(Book book : reserveBookList) {
			BookView reserve = new BookView();
			reserve.setBook(book);
			reserve.setCategory(categoryBO.getCategoryByCategoryId(book.getId()));
			reserve.setReturnInfo(borrowBO.getLatestReturnAtByBookId(book.getId()));
			reserveViewList.add(reserve);
		}
		return reserveViewList;
	}
	public List<BookView> generateBookmarkViewList(int userId){
		List<BookView> bookmarkViewList = new ArrayList<>();
		List<Book> bookmarkBookList = new ArrayList<>();
		
		// list에 있는 int값을 다시 변수로 넣어 list값을 뽑아내야 하므로 for문을 돌린다.
		for(Bookmark bookmark : bookmarkBO.getBookmarkListByUserId(userId)) {
			Book book = bookBO.getBookByBookId(bookmark.getBookId());
			bookmarkBookList.add(book);
		}
		
		for(Book book : bookmarkBookList) {
			BookView bookmark = new BookView();
			bookmark.setBook(book);
			bookmark.setCategory(categoryBO.getCategoryByCategoryId(book.getId()));
			bookmark.setReturnInfo(borrowBO.getLatestReturnAtByBookId(book.getId()));
			bookmarkViewList.add(bookmark);
		}
		return bookmarkViewList;
	}
	
}
