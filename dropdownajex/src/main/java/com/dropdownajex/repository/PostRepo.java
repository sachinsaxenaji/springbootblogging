package com.dropdownajex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dropdownajex.entity.CategoryEntity;
import com.dropdownajex.entity.PostEntity;
import com.dropdownajex.entity.UserEntity;

public interface PostRepo extends JpaRepository<PostEntity, Integer> {
	
	public List<PostEntity>  findByUser(UserEntity user);
	
	public List<PostEntity> findByCategory(CategoryEntity category);
	
	

}
