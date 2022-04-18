package com.ebook.borrow.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowDAO {
	public int insertBorrow(
			@Param("userId")int userId,
			@Param("bookId")int bookId) ;
	public int countBorrowByUserIdAndBookId(
			@Param("userId")int userId,
			@Param("bookId")int bookId);
}
