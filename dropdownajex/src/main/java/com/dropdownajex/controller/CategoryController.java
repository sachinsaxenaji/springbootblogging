package com.dropdownajex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dropdownajex.entity.CategoryEntity;
import com.dropdownajex.service.CategoryService;


@RestController
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/category/get")
	public List<CategoryEntity> getCategorys()
	{
		List<CategoryEntity> categories = this.categoryService.getCategorys();
		
		return categories;
	}
	
	@PostMapping("/category/save")
	public ResponseEntity<String> saveCategory(@RequestBody CategoryEntity category){
		
		this.categoryService.addCategory(category);
		
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

}
