package com.ebook.book;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/book")
@RestController
public class BookRestController {
	@RequestMapping("/search")
	public Map<String, Object> bookSearch(){
		// 나중에
	}
}
