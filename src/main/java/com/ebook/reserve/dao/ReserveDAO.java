package com.ebook.reserve.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ebook.reserve.model.Reserve;

@Repository
public interface ReserveDAO {
	public int insertReserve(
			@Param("userId")int userId, 
			@Param("bookId")int bookId);
	public List<Reserve> selectReserveList(int bookId);
	public List<Reserve> selectReserveListByUserId(int userId);
	public int deleteReserve(
			@Param("userId")int userId, 
			@Param("bookId")int bookId);
	public int countReserveByUserIdAndBookId(
			@Param("userId")int userId, 
			@Param("bookId")int bookId);
}
