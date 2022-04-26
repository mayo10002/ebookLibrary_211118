package com.ebook.reserve;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.borrow.bo.BorrowBO;
import com.ebook.reserve.bo.ReserveBO;

@RequestMapping("/reserve")
@RestController
public class ReserveRestController {
	@Autowired
	private ReserveBO reserveBO;
	@Autowired
	private BorrowBO borrowBO;
	// 예약하기
	@RequestMapping("/{bookId}")
	public Map<String, Object> reserve(
			@PathVariable int bookId,
			HttpSession session){
		int userId = (int)session.getAttribute("userId");
		Map<String, Object> result = new HashMap<>();
		// insert DB
		if (borrowBO.countBorrowByUserIdAndBookId(userId, bookId) == 1) {
			result.put("result","error");
			result.put("error_message","이미 대출 중인 책입니다.");
		}else if(reserveBO.countReserveByUserIdAndBookId(userId, bookId) == 1) {
			result.put("result","error");
			result.put("error_message","이미 예약 중인 책입니다.");
		}else {
			int row = reserveBO.addReserve(userId, bookId);
			if(row < 1) {
				result.put("result", "error");
				result.put("error_message", "도서 예약에 실패했습니다.");
			}else {
				result.put("result", "success");
				
			}
		}
		return result;
	}
	//예약 취소
	@RequestMapping("/delete/{bookId}")
	public Map<String, Object> delete(
			@PathVariable int bookId,
			HttpSession session){
		
	}
}
