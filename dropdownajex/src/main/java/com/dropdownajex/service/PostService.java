package com.dropdownajex.service;

import java.util.List;

import com.dropdownajex.dto.PostDto;
import com.dropdownajex.dto.PostResponse;
import com.dropdownajex.entity.PostEntity;


public interface PostService {

	
		
	public PostDto getPost(int post_id);
	
	public PostResponse getPosts(Integer pageNo, Integer pageSize);
	
	public void savePost(PostDto postEntity,  int user_id, int cat_id);
	
	public void updatePost(int post_id);
	
	public void deletePost(int post_id);

	public List<PostDto> getCatPost(int cat_id);
}
