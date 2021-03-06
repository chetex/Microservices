package com.formacionbdi.springboot.app.productos.sprinbootservicioproductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SprinbootServicioProductosApplication {
	public static void main(String[] args) {
		SpringApplication.run(SprinbootServicioProductosApplication.class, args);
	}
}
