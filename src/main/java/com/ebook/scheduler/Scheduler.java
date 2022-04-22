package com.ebook.scheduler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebook.book.bo.BookBO;
import com.ebook.borrow.bo.BorrowBO;
import com.ebook.borrow.model.Borrow;

@Component
@RequestMapping("/delete_auto")
@RestController
public class Scheduler {
	@Autowired
	private BorrowBO borrowBO;
	@Autowired
	private BookBO bookBO;
	//밤 12시마다 자동 반납 : 날짜 차이가 -1이 되는 날(반납일 당일까지는 대출 상태)
	@Scheduled(cron = "0 0 0 * * *")
	//@Scheduled(cron = "0 * * * * *")
	public Map<String, Object> dayDelete(){
		Map<String, Object> result = new HashMap<>();
		//모든 book에서 반납일과 오늘 날짜가 같은 책의 borrow테이블 list를 받아오기(userId 랑 bookId 써먹어야 하니까)
		List<Borrow> expiredBook = borrowBO.getExpiredBorrowList();
		
		// borrowList에 대해 반납 for문 돌리기. 아니면 반납쿼리를 id에 대해 for문을 돌리는 방식으로 따로 만들기. 밑에 있는 반납 쿼리 그대로 적용하려면 bookId가 필요하긴 함
		for(Borrow borrow : expiredBook) {
			int row = borrowBO.deleteBorrowById(borrow.getId());
			if( row < 1) {
				result.put("result", "error");
				result.put("error_message", "도서 반납에 실패했습니다.");
				return result;
				
			}else {
				
				int bookCount = borrowBO.countBorrowByBookId(borrow.getBookId());
				if(bookBO.getBookByBookId(borrow.getBookId()).getState().equals("예약 가능") && bookCount == 4) {
					bookBO.changeStateToBorrowByBookId(borrow.getBookId());
				}
			}
		}
		result.put("result", "success");
		return result;		
	}
}
