package com.dropdownajex.service;

import java.util.List;

import com.dropdownajex.entity.CategoryEntity;

public interface CategoryService {
	
	public List<CategoryEntity> getCategorys();
	
	public void addCategory(CategoryEntity category);

}
