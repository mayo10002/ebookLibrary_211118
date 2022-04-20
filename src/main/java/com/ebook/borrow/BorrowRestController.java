package com.ebook.borrow;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.borrow.bo.BorrowBO;

@RequestMapping("/borrow")
@RestController
public class BorrowRestController {
	@Autowired
	private BorrowBO borrowBO;
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
			}
		}
		return result;
	}
	// 도서 상태 업데이트 구문 >  bookBO 에서 
	// bookCount가 4에서 5로 넘어가고나서 대출처리가 된 순간 bookBO에서 자동으로 update구문이 돌아가야 한다. 
	// bookCount가 5에서 4로 내려가도 마찬가지로 자동 update
	// 누군가 도서를 반납했을 시 예약 1순위 사용자를 불러와 자동 대출 처리
	@RequestMapping("/delete_update/{bookId}")
	public Map<String,Object> bookUpdate(@PathVariable int bookId,
			HttpSession session){
		int userId = (int)session.getAttribute("userId");
		Map<String, Object> result = new HashMap<>();
		
		// insert DB
		int bookCount = borrowBO.countBorrowByBookId(bookId);
		if(bookCount == 5) {
			
		}
		
	}
	//밤 12시마다 자동 반납
	@RequestMapping("/delete_auto/{bookId}")
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
