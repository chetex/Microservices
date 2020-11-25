package com.formacionbdi.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@RibbonClient(name = "servicio-productos") // Add feature to get propertly information from Ribbon. Está escrito en el application.properties.
@EnableFeignClients // With EnableFeignClients we enabled feign configuration to connect other clients.
public class SpringbootServicioItemApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioItemApplication.class, args);
	}
}
