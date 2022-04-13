package com.ebook.category.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
	private int id;
	private String categoryName;
	private Date createdAt;
	private Date updatedAt;
}
