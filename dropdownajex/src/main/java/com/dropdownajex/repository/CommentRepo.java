package com.dropdownajex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dropdownajex.entity.CommentEntity;

public interface CommentRepo extends JpaRepository<CommentEntity, Integer>{

}
