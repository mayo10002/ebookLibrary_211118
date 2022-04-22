package com.ebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@EnableScheduling
public class EbookLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbookLibraryApplication.class, args);
	}

}
