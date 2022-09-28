package com.dropdownajex.dto;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.dropdownajex.entity.CommentEntity;
import com.dropdownajex.entity.PostEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
public class UserDto {

	
	private Integer user_id;
	
	@NotEmpty(message = "name can not be empty")
	private String name;
	
	@NotEmpty(message = "username can not be empty")
	private String username;
	
	
	@NotEmpty(message = "password can not be empty")
	private String password;
	
	@NotEmpty(message = "about can not be empty")
	private String about;
	
	private List<CommentEntity> comment ;
	
	private List<PostEntity> post ;

	


}