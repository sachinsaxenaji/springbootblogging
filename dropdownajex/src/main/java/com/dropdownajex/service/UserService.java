package com.dropdownajex.service;

import java.util.List;
import com.dropdownajex.dto.UserDto;
import com.dropdownajex.entity.UserEntity;
import com.dropdownajex.exception.MyException;



public interface UserService {
	
	public List<UserDto> getAllUser();
	
	public UserDto updateUser(UserDto u, int id);
	
	public UserDto getUser(int id) throws MyException;
	
	public List<UserEntity> saveUser(List<UserDto> u);
	
	public UserEntity saveUsers(UserDto u);
	
	public UserDto deleteUser(int id);
	
	

}
