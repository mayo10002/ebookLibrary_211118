package com.ebook.reserve.bo;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.borrow.bo.BorrowBO;
import com.ebook.reserve.dao.ReserveDAO;
import com.ebook.reserve.model.Reserve;

@Service
public class ReserveBO {
	@Autowired
	private ReserveDAO reserveDAO;
	@Autowired
	private BorrowBO borrowBO;
	// 예약 추가
	public int addReserve(int userId, int bookId) {
		return reserveDAO.insertReserve(userId, bookId);
	}
	// 예약 리스트 불러오기
	public List<Reserve> getReserveList(int bookId) {
		return reserveDAO.selectReserveList(bookId);
	}
	// mypage 예약 리스트 불러오기
	public List<Reserve> getReserveListByUserId(int userId){
		return reserveDAO.selectReserveListByUserId(userId);
	}
	// 예약 확인 용
	public int countReserveByUserIdAndBookId(int userId, int bookId) {
		return reserveDAO.countReserveByUserIdAndBookId(userId, bookId);
	}
	// 예약 취소
	public int deleteReserve(int userId, int bookId) {
		return reserveDAO.deleteReserve(userId, bookId);
	}
	// 예약 리스트에서 for문을 돌려? 이미 5권을 전부 대출하고 있는 사람은 제외하고 남는 사람을 선택하여 userId 내보내기
	public Integer getReserveAvailableUserId(int bookId) {
		List<Reserve> reserveBook = getReserveList(bookId);
		
		Collections.sort(reserveBook, (Reserve one, Reserve other) -> {
		     return one.getCreatedAt().compareTo(other.getCreatedAt());
		});
		Integer reserveUserId = null;
		for(Reserve reserve :reserveBook) {
			if (borrowBO.countBorrowByUserId(reserve.getUserId()) < 5) {
				reserveUserId = reserve.getUserId();
				break;
			}else {
				continue;
			}
		}
		return reserveUserId;
		
	}
}