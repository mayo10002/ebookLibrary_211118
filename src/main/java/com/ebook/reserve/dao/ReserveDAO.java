package com.ebook.reserve.dao;

import org.springframework.stereotype.Repository;

import com.ebook.reserve.model.Reserve;

@Repository
public interface ReserveDAO {
	public int insertReserve(int userId, int bookId);
	public Reserve selectFirstReserve(int bookId);
	public void deleteReserve(int userId, int bookId);
	public int countReserveByUserIdAndBookId(int userId, int bookId);
}
