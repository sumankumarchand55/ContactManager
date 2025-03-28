package com.smart.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SmartcontactmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartcontactmanagerApplication.class, args);
	}

}
