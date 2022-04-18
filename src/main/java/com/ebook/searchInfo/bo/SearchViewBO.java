package com.ebook.searchInfo.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.book.bo.BookBO;
import com.ebook.book.model.Book;
import com.ebook.bookmark.bo.BookmarkBO;
import com.ebook.category.bo.CategoryBO;
import com.ebook.category.model.Category;
import com.ebook.searchInfo.model.BookInfoView;
import com.ebook.searchInfo.model.SearchBookView;

@Service
public class SearchViewBO {
	@Autowired
	private BookBO bookBO;
	@Autowired
	private BookmarkBO bookmarkBO;
	@Autowired 
	private CategoryBO categoryBO;
	public List<SearchBookView> generateSearchViewList(String searchText, Integer userId){
		List<SearchBookView> searchViewList = new ArrayList<>();
		List<Book> bookList = bookBO.getBookBySearchText(searchText);
		for(Book book : bookList) {
			SearchBookView search = new SearchBookView();
			
			search.setBook(book);
			search.setFilledBookmark(bookmarkBO.existBookmark(userId, book.getId()));
			searchViewList.add(search);
		}
		
		return searchViewList;
	}
	public BookInfoView generateInfoView( Integer userId, int bookId) {
		BookInfoView info = new BookInfoView();
		Book bookInfo = bookBO.getBookByBookId(bookId);
		info.setBook(bookInfo);
		Category categoryInfo = categoryBO.getCategoryByCategoryId(bookInfo.getCategoryId());
		info.setCategory(categoryInfo);
		info.setFilledBookmark(bookmarkBO.existBookmark(userId, bookInfo.getId()));
		
		
		// borrow
	}
}
