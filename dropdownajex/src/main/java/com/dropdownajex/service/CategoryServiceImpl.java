package com.dropdownajex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dropdownajex.entity.CategoryEntity;
import com.dropdownajex.repository.CategoryRepo;


@Service
public class CategoryServiceImpl implements CategoryService{

	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Override
	public List<CategoryEntity> getCategorys() {
		
		List<CategoryEntity> categoryEntity = this.categoryRepo.findAll();
		return categoryEntity;
	}

	@Override
	public void addCategory(CategoryEntity category) {
		// TODO Auto-generated method stub
		this.categoryRepo.save(category);
	}

}
