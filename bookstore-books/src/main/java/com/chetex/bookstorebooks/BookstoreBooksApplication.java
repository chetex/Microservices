package com.chetex.bookstorebooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookstoreBooksApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookstoreBooksApplication.class, args);
	}
}
