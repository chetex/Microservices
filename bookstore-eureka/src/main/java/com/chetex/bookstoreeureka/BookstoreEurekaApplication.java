package com.chetex.bookstoreeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BookstoreEurekaApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookstoreEurekaApplication.class, args);
	}
}
