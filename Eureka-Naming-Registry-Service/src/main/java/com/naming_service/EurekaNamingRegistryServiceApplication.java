package com.naming_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaNamingRegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaNamingRegistryServiceApplication.class, args);
	}

}
