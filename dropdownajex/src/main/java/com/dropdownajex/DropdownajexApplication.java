package com.dropdownajex;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DropdownajexApplication {

	public static void main(String[] args) {
		SpringApplication.run(DropdownajexApplication.class, args);
		
		System.out.println("Hello, I'm main ");
	
	}
	
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

}
