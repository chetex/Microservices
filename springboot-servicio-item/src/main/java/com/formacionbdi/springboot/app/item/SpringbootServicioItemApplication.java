package com.formacionbdi.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // With EnableFeignClients we enabled feign configuration to connect other clients.
public class SpringbootServicioItemApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioItemApplication.class, args);
	}
}
