package com.cowaine.crupy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
//@ConfigurationPropertiesScan("com.cowaine.crupy.part6")
public class CrupyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrupyApplication.class, args);
	}

}
