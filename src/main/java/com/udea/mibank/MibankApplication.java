package com.udea.mibank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= "com.udea.mibank")
public class MibankApplication {

	public static void main(String[] args) {
		SpringApplication.run(MibankApplication.class, args);
	}

}
