package com.ebook.bookmark.dao;

import org.apache.ibatis.annotations.Param;

public interface BookmarkDAO {
	public void insertBookmark(
			@Param("userId")int userId,
			@Param("bookId")int bookId);
	public int existBookmark(
			@Param("userId")int userId,
			@Param("bookId")int bookId);
	public void deleteBookmarkByBookIdAndUserId(
			@Param("userId")int userId,
			@Param("bookId")int bookId) ;
}
