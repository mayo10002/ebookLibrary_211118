package com.ebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@EnableScheduling
public class EbookLibraryApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EbookLibraryApplication.class, args);
	}

}
