package com.ebook.borrow.dao;

import java.util.Date;

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
	public Date selectLatestReturnAtByBookId(int bookId);
	public void deleteBorrow(
			@Param("userId")int userId,
			@Param("bookId")int bookId);
	public int updateReturnAtByUserIdAndBookId(
			@Param("userId")int userId,
			@Param("bookId")int bookId);
	public int selectExtendBorrowByUserIdAndBookId(
			@Param("userId")int userId,
			@Param("bookId")int bookId);
}
