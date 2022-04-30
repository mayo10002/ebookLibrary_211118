package com.ebook.mypage.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.book.bo.BookBO;
import com.ebook.book.model.Book;
import com.ebook.borrow.bo.BorrowBO;
import com.ebook.borrow.model.Borrow;
import com.ebook.category.bo.CategoryBO;
import com.ebook.category.model.Category;
import com.ebook.mypage.model.BookView;

@Service
public class MypageViewBO {
	@Autowired
	private BookBO bookBO;
	@Autowired
	private BorrowBO borrowBO;
	@Autowired
	private CategoryBO categoryBO;
	List<BookView> generateBorrowViewList(int userId){
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
	
	List<BookView> generateReserveViewList(int userId){
		List<BookView> reserveViewList = new ArrayList<>();
		List<Book> reserveBookList = new ArrayList<>();
		
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
}
