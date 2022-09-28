package com.dropdownajex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dropdownajex.dto.CommentDto;

public interface CommentService {
	
	public void saveComments(CommentDto comments,int user_id,int post_id);
	
	public List<CommentDto> showComments();
		

}
