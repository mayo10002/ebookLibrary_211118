package com.ebook.category.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebook.category.dao.CategoryDAO;
import com.ebook.category.model.Category;

@Service
public class CategoryBO {
	@Autowired
	private CategoryDAO categoryDAO;
	public Category getCategoryByCategoryId(int categoryId) {
		return categoryDAO.selectCategoryByCategoryId(categoryId);
	}
}
