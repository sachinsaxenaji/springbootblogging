package com.dropdownajex.controller;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dropdownajex.dto.UserDto;
import com.dropdownajex.entity.UserEntity;
import com.dropdownajex.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/users")
	public List<UserDto> showUsers()
	{
		return userService.getAllUser(); 
		
	}
	@PostMapping("/users/save")
	public ResponseEntity<UserDto> saveUsers(@Valid @RequestBody UserDto user)
	{
		
		try {
			
			//user.stream().map(a -> userService.saveUsers(a));
			userService.saveUsers(user);
			
			
			return new ResponseEntity<UserDto> (HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<UserDto> (HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/user/save")
	public ResponseEntity<UserDto> saveUser(@Valid @RequestBody List<UserDto>  user)
	{
		
		try {
			
			List<UserEntity> uDtos  =  user.stream().map(a -> userService.saveUsers(a)).collect(Collectors.toList());
			//userService.saveUsers(user);
			
			return new ResponseEntity<UserDto> (HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<UserDto> (HttpStatus.BAD_REQUEST);
		}
	}

}
