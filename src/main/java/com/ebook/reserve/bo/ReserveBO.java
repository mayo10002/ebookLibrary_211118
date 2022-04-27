package com.ebook.reserve.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.reserve.dao.ReserveDAO;
import com.ebook.reserve.model.Reserve;

@Service
public class ReserveBO {
	@Autowired
	private ReserveDAO reserveDAO;	
	
	// 예약 추가
	public int addReserve(int userId, int bookId) {
		return reserveDAO.insertReserve(userId, bookId);
	}
	// 가장 빠른 예약자 1명 선택 
	public Reserve getFirstReserve(int bookId) {
		return reserveDAO.selectFirstReserve(bookId);
	}
	// 예약 확인 용
	public int countReserveByUserIdAndBookId(int userId, int bookId) {
		return reserveDAO.countReserveByUserIdAndBookId(userId, bookId);
	}
	// 예약 취소
	public int deleteReserve(int userId, int bookId) {
		return reserveDAO.deleteReserve(userId, bookId);
	}
}
