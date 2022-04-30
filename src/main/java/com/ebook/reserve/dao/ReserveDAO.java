package com.ebook.reserve.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ebook.reserve.model.Reserve;

@Repository
public interface ReserveDAO {
	public int insertReserve(int userId, int bookId);
	public List<Reserve> selectReserveList(int bookId);
	public List<Reserve> selectReserveListByUserId(int userId);
	public int deleteReserve(int userId, int bookId);
	public int countReserveByUserIdAndBookId(int userId, int bookId);
}
