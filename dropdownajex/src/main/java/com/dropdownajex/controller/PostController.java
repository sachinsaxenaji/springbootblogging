package com.dropdownajex.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dropdownajex.dto.PostDto;
import com.dropdownajex.dto.PostResponse;
import com.dropdownajex.entity.PostEntity;
import com.dropdownajex.exception.ApiResponce;
import com.dropdownajex.service.PostService;

@RestController
public class PostController {
	
	@Autowired
	PostService postService;
	
	@PostMapping("/post/save/{cat_id}/{user_id}")
	public ResponseEntity<ApiResponce> savePost( @Valid @RequestBody PostDto mypost, @PathVariable("cat_id") int cat_id, @PathVariable("user_id") int user_id)
	{
		
		
		this.postService.savePost(mypost, user_id, cat_id);
		
		return new ResponseEntity<ApiResponce>(HttpStatus.CREATED);
		
	}
	
	@GetMapping("/posts")
	public PostResponse showPost(@RequestParam(value = "pageNumber", defaultValue = "0", required =false) Integer pageNumber, @RequestParam(value = "pageSize", defaultValue = "2", required =false) Integer pageSize)
	{
		return this.postService.getPosts(pageNumber, pageSize);
	}
	
	@GetMapping("/posts/{cat_id}")
	public ResponseEntity<List<PostDto>> showPost(@PathVariable int cat_id)
	{
		List<PostDto> postEntity =  this.postService.getCatPost(cat_id);
		 
		 return  new ResponseEntity<List<PostDto>>(postEntity,HttpStatus.OK);
	}
	
	@GetMapping("/post/{id}")
	public ResponseEntity<ApiResponce> deletePost(@PathVariable("id") int post_id)
	
	{
		this.postService.deletePost(post_id);
		
		return new ResponseEntity<ApiResponce>(HttpStatus.ACCEPTED);
		
	}


}
