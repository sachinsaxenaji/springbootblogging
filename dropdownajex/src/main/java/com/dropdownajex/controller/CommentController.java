package com.dropdownajex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dropdownajex.dto.CommentDto;
import com.dropdownajex.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/comment/save/{user_id}/{post_id}")
	public ResponseEntity<CommentDto> saveComment(@RequestBody  CommentDto comments, @PathVariable int user_id, @PathVariable int post_id) 
	
	{
		this.commentService.saveComments(comments, user_id, post_id);
		return new ResponseEntity<CommentDto>(HttpStatus.CREATED);
	}
	
	@GetMapping("/comments/show")
	public ResponseEntity<List<CommentDto>> showComments()
	{
	List<CommentDto> commentDtos = 	this.commentService.showComments();
	
	return new ResponseEntity<List<CommentDto>>(commentDtos, HttpStatus.OK);
	}

}
