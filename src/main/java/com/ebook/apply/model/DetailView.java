package com.ebook.apply.model;

import com.ebook.user.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailView {
	private User user;
	private Apply apply;
}
