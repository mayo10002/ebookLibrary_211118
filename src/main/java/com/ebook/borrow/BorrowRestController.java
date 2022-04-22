package com.ebook.borrow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.book.bo.BookBO;
import com.ebook.borrow.bo.BorrowBO;
import com.ebook.borrow.model.Borrow;

@RequestMapping("/borrow")
@RestController
public class BorrowRestController {
	@Autowired
	private BorrowBO borrowBO;
	@Autowired 
	private BookBO bookBO;
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

	//밤 12시마다 자동 반납 : 날짜 차이가 -1이 되는 날(반납일 당일까지는 대출 상태)
	@RequestMapping("/delete_auto/{bookId}")
	public Map<String, Object> dayDelete(){
		//모든 book에서 반납일과 오늘 날짜가 같은 책의 borrow테이블 list를 받아오기(userId 랑 bookId 써먹어야 하니까)
		List<Borrow> expiredBook = borrowBO.getExpiredBorrowList();
		// 
		// borrowList에 대해 반납 for문 돌리기. 아니면 반납쿼리를 id에 대해 for문을 돌리는 방식으로 따로 만들기. 밑에 있는 반납 쿼리 그대로 적용하려면 bookId가 필요하긴 함
		for(Borrow borrow : expiredBook) {
			
		}
		
	}
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
			if(bookBO.getBookByBookId(bookId).getState().equals("예약 가능") && bookCount == 4) {
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
