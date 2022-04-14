package com.ebook.searchInfo.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.book.bo.BookBO;
import com.ebook.bookmark.bo.BookmarkBO;

@Service
public class SearchViewBO {
	@Autowired
	private BookBO bookBO;
	@Autowired
	private BookmarkBO bookmarkBO;
	// 북마크 BO부터 빌드해야함 (count메소드부터) 
	public List<>
}
