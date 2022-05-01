package com.ebook.bookmark.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.bookmark.dao.BookmarkDAO;
import com.ebook.bookmark.model.Bookmark;

@Service
public class BookmarkBO {
	@Autowired
	private BookmarkDAO bookmarkDAO;
	
	public void addBookmark(int userId, int bookId) {
		boolean existBookmark = existBookmark(userId, bookId);
		
		if(existBookmark == true) {
			bookmarkDAO.deleteBookmarkByBookIdAndUserId(userId, bookId);
		}else {
			bookmarkDAO.insertBookmark(userId, bookId);
		}
	}
	public boolean existBookmark(Integer userId, int bookId) {
		if(userId == null) {
			return false;
		}
		int count = bookmarkDAO.existBookmark(userId, bookId);
		return count > 0? true : false;
	}
	public void deleteBookmarkByBookIdAndUserId(int userId, int bookId) {
		bookmarkDAO.deleteBookmarkByBookIdAndUserId(userId, bookId);
	}
	public List<Bookmark> getBookmarkListByUserId(int userId){
		return bookmarkDAO.selectBookmarkListByUserId(userId);
	}
}

