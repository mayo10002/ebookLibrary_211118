package com.ebook.category.dao;

import org.springframework.stereotype.Repository;

import com.ebook.category.model.Category;

@Repository
public interface CategoryDAO {
	public Category selectCategoryByCategoryId(int categoryId);
}
