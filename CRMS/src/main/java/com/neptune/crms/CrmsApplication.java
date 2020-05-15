package com.neptune.crms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.neptune.crms")
@EnableSwagger2
public class CrmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmsApplication.class, args);
		System.out.println("Program executed succesfully");
	}

}
