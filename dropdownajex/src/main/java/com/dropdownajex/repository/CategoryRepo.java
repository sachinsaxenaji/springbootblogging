package com.dropdownajex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dropdownajex.entity.CategoryEntity;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer>{

}
