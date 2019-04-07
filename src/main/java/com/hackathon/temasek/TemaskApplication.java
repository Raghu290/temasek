package com.hackathon.temasek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.hackathon.temasek")
public class TemaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemaskApplication.class, args);
	}

}
