package com.dropdownajex.dto;

import com.dropdownajex.entity.PostEntity;
import com.dropdownajex.entity.UserEntity;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CommentDto {
	
	
	private Integer  comment_id;
	
	private String comment;
	
	
	private UserEntity user;
	
	private PostEntity post;

}
