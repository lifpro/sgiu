package com.technolab.registrationsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RegistrationsvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationsvcApplication.class, args);
	}

}
