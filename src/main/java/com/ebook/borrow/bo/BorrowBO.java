package com.ebook.borrow.bo;

import java.util.Date;
import java.util.List;

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
	// 책 현재 대출 상태인지 조회
	public int countBorrowStateByBookId(int bookId) {
		return borrowDAO.countBorrowStateByBookId(bookId);
	}
	// 도서로 대출 일자 조회
	public int countBorrowByBookId(int bookId) {
		return borrowDAO.countBorrowByBookId(bookId);
	}
	// 사용자 id로 대출 일자 조회 
	public int countBorrowByUserId(int userId) {
		return borrowDAO.countBorrowByUserId(userId);
	}
	// 반납 일자 조회용. 그 중에서도 가장 빠른 반납일자를 골라야 함. book 테이블에서 state가 대출 가능일 때는 보이지 않게 jstl로 처리하기.
	public Date getLatestReturnAtByBookId(int bookId) {
		return borrowDAO.selectLatestReturnAtByBookId(bookId);
	}
	public Date getReturnAtByBookIdAndUserId(int userId, int bookId) {
		return borrowDAO.selectReturnAtByBookIdAndUserId(userId, bookId);
	}
	// 반납 - delete
	public int deleteBorrow(int userId, int bookId) {
		return borrowDAO.deleteBorrow(userId, bookId);
	}
	// 연장 - update (put방식)
	public int updateReturnAtByUserIdAndBookId(int userId, int bookId) {
		return borrowDAO.updateReturnAtByUserIdAndBookId(userId, bookId);
	}
	
	//이미 한 번 빌렸을 경우 연장 방지 count- select : 7일 경우 연장 가능, 14일 경우 연장 불가.(이미 한 번 연장 해서)
	public int getExtendBorrowByUserIdAndBookId(int userId, int bookId) {
		return borrowDAO.selectExtendBorrowByUserIdAndBookId(userId, bookId);
	}
	// 반납해야 하는 책 select
	public List<Borrow> getExpiredBorrowList(){
		return borrowDAO.selectExpiredBorrowList();
	}
	// id에 따라 반납
	public int deleteBorrowById(int id) {
		return borrowDAO.deleteBorrowById(id);
	}
	//가장 최근에 빌린 책 select 
	public Integer getLatestBorrowBookId(int userId) {
		return borrowDAO.selectLatestBorrowBookId(userId);
	}
	public List<Borrow> getBorrowByUserId(int userId){
		return borrowDAO.selectBorrowByUserId(userId);
	}
}
