package com.dropdownajex.controller;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dropdownajex.service.AddDataService;
import com.dropdownajex.service.AddDataServiceImpl;



@RestController
public class ShowddController {
	
	@Autowired
	AddDataServiceImpl addDataServiceImpl;
	
	@RequestMapping("/show")
	public String show()
	{
		
		 System.out.println("Hello I'm Controller");
		 
		 
		return "<div>Hello</div>";
	}
	
	
	

}
