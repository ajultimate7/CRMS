package com.neptune.crms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.neptune.crms")
public class CrmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmsApplication.class, args);
	}

}
