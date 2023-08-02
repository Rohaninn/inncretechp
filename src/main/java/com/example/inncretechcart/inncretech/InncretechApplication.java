package com.example.inncretechcart.inncretech;

import org.springframework.boot.SpringApplication;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InncretechApplication {

	public static void main(String[] args) {
		SpringApplication.run(InncretechApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();

	}

}
