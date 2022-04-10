package com.ebook.test;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ebook.user.bo.UserBO;

@Controller
public class TestController {
	@Autowired
	private UserBO userBO;
	@ResponseBody
	    @RequestMapping("/test1")
	    public String helloWorld() {
	        return "Hello world!";
	    }
//	    @RequestMapping("/test2")
//	    public String helloWorld2() {
//	    	return "test/test";
//	    }
	    @RequestMapping("/test3")
	    public String helloWorld3(){
	    	if (userBO.getUser(1) != null) {
	    		return "test/test3";
	    	}
	    	return "test/error";
	    }
}
