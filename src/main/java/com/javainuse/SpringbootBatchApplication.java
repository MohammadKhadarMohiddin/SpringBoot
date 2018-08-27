package com.javainuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.elamp.controller"})
public class SpringbootBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBatchApplication.class, args);
	}
}
