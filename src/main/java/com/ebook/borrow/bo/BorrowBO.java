package com.ebook.borrow.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.borrow.dao.BorrowDAO;
import com.ebook.borrow.model.Borrow;

@Service
public class BorrowBO {
	@Autowired
	private BorrowDAO borrowDAO;
	
	//대출 기록 추가
	public int createBorrow(int userId,int bookId) {
		return borrowDAO.insertBorrow(userId, bookId);
	}
	
	// 대출 기록 조회
	public int countBorrowByUserIdAndBookId(int userId, int bookId) {
		return borrowDAO.countBorrowByUserIdAndBookId(userId, bookId);
	}
	// 반납 일자 조회용 > 그 중에서도 가장 빠른 반납일자를 골라야 함
	public Borrow getBorrowByBookId(int bookId) {
		return borrowDAO
	}
	// 반납 - delete
	public int deleteBorrow(int userId, int bookId) {
		return borrowDAO
	}
	// 연장 - update (put방식)
	
}
