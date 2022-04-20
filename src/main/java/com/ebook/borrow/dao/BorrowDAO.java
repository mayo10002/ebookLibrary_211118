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
	public int countBorrowByBookId(int bookId);
	public int countBorrowByUserId(int userId);
	public Date selectLatestReturnAtByBookId(int bookId);
	public int deleteBorrow(
			@Param("userId")int userId,
			@Param("bookId")int bookId);
	public int updateReturnAtByUserIdAndBookId(
			@Param("userId")int userId,
			@Param("bookId")int bookId);
	public int selectExtendBorrowByUserIdAndBookId(
			@Param("userId")int userId,
			@Param("bookId")int bookId);
}
