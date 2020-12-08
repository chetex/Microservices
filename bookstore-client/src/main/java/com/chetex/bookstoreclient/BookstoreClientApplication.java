package com.chetex.bookstoreclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
// @RibbonClient(name = "bookstore-books")
public class BookstoreClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookstoreClientApplication.class, args);
	}
}
