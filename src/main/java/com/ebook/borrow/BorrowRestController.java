package com.ebook.borrow;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.book.bo.BookBO;
import com.ebook.borrow.bo.BorrowBO;
import com.ebook.reserve.bo.ReserveBO;

@RequestMapping("/borrow")
@RestController
public class BorrowRestController {
	@Autowired
	private BorrowBO borrowBO;
	@Autowired 
	private BookBO bookBO;
	@Autowired
	private ReserveBO reserveBO;
	// 대출 가능 조건 충족 시 : userId로 찾은 borrow 데이터 개수도, bookId로 찾은 borrow 데이터 개수도 count 5 미만일 때
	@RequestMapping("/borrow/{bookId}")
	public Map<String, Object> borrow(
			@PathVariable int bookId,
			HttpSession session){
		int userId = (int)session.getAttribute("userId");
		Map<String, Object> result = new HashMap<>();
		
		//insert DB
		int bookCount = borrowBO.countBorrowByBookId(bookId);
		int userCount = borrowBO.countBorrowByUserId(userId);
		
		if (bookCount >= 5) {
			result.put("result","error");
			result.put("error_message","현재 대출 가능한 도서 재고가 없습니다.");
		}else if(userCount >= 5){
			result.put("result","error");
			result.put("error_message","대출 가능 권수를 초과했습니다.");
		}else if(borrowBO.countBorrowByUserIdAndBookId(userId, bookId) == 1){
			result.put("result","error");
			result.put("error_message","이미 대출 중인 책입니다.");
		}else {
			int row = borrowBO.createBorrow(userId, bookId);
			if( row < 1) {
				result.put("result", "error");
				result.put("error_message", "도서 대출에 실패했습니다.");
			}else {
				result.put("result", "success");
				if(bookCount == 5) {
					bookBO.changeStateToReserveByBookId(bookId);
				}
			}
		}
		return result;
	}

	//자동 반납 메소드는 schedule에
	//reserve가져와야함. 수동 반납했을 때 만약 bookId 예약자리를 가지고 있는 사람이 존재하면 그 사람을 바로 borrow처리시켜야 한다.
	// 수동 반납
	@DeleteMapping("/delete/{bookId}")
	public Map<String, Object> delete(
			@PathVariable int bookId,
			HttpSession session){
		int userId = (int)session.getAttribute("userId");
		Map<String, Object> result = new HashMap<>();
		
		// insertDB
		int row = borrowBO.deleteBorrow(userId, bookId);
		if( row < 1) {
			result.put("result", "error");
			result.put("error_message", "도서 반납에 실패했습니다.");
		}else {
			result.put("result", "success");
			int bookCount = borrowBO.countBorrowByBookId(bookId);
			//여기에 reserve 목록이 있을 경우 최상단 user를 가져와 borrow처리시켜줘야 한다. book의 state는 바꿀 필요가 없다. 
			if(reserveBO.getFirstReserve(bookId) != null) {
				int reserveUserId = reserveBO.getFirstReserve(bookId).getUserId();
				int userCount =  borrowBO.countBorrowByUserId(reserveUserId);
				if(userCount>= 5){
					// 1순위 예약자가 이미 책 5권을 전부 빌렸을 경우 다음 예약자로 넘어가야하는 건가?
					result.put("result","error");
					result.put("error_message","대출 가능 권수를 초과했습니다.");
					// id 순위 찾아서 다음 예약자 찾는 query 만들어야 함. 위의 resulterror는 DB 넣고 나서 지우자.
				}else {
					borrowBO.createBorrow(reserveUserId, bookId);
				}
			}else if(bookBO.getBookByBookId(bookId).getState().equals("예약 가능") && bookCount == 4) {
				bookBO.changeStateToBorrowByBookId(bookId);
			}
		}
		return result;
	}
	// 연장 가능 조건 충족 시 연장
	@RequestMapping("/extend/{bookId}")
	public Map<String, Object> extend(
			@PathVariable int bookId,
			HttpSession session){
		int userId = (int)session.getAttribute("userId");
		Map<String, Object> result = new HashMap<>();
		
		// insert DB : 대출 기간이 7일보다 많으면 연장을 한 번 했다는 것이기 때문에 또 연장하지 못한다.
		int extendCount = borrowBO.getExtendBorrowByUserIdAndBookId(userId, bookId);
		if(extendCount < 8) {
			int row = borrowBO.updateReturnAtByUserIdAndBookId(userId, bookId);
			if (row < 1) {
				result.put("result", "error");
				result.put("error_message", "도서 대출 연장에 실패했습니다.");
			}else {
				result.put("result", "success");
			}
		}else { 
			result.put("result", "error");
			result.put("error_message", "이미 해당 도서의 대출 기간을 연장하셨습니다.");
		}
		return result;
	}
}
