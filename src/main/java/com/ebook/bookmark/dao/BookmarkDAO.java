package com.ebook.bookmark.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ebook.bookmark.model.Bookmark;
@Repository
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
	public List<Bookmark> selectBookmarkListByUserId(int userId);
}
