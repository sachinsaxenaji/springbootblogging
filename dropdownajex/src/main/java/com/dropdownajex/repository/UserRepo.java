package com.dropdownajex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dropdownajex.entity.UserEntity;



public interface UserRepo extends JpaRepository<UserEntity, Integer>{


}
