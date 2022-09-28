package com.dropdownajex.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dropdownajex.dto.PostDto;
import com.dropdownajex.dto.PostResponse;
import com.dropdownajex.entity.CategoryEntity;
import com.dropdownajex.entity.PostEntity;
import com.dropdownajex.entity.UserEntity;
import com.dropdownajex.exception.MyException;
import com.dropdownajex.repository.CategoryRepo;
import com.dropdownajex.repository.PostRepo;
import com.dropdownajex.repository.UserRepo;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	PostRepo postRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	

	@Override
	public PostDto getPost(int post_id) {
		
		
		PostEntity post = this.postRepo.findById(post_id).orElseThrow();
		
		PostDto postDto	 = modelMapper.map(post, PostDto.class);
		return postDto;
	}

	@Override
	public PostResponse getPosts(Integer pageNo, Integer pageSize) {
		
		PostResponse postResponse = new PostResponse();
		
		 Pageable pageable = PageRequest.of(pageNo, pageSize);
		
		
		Page<PostEntity> pagePosts=  this.postRepo.findAll(pageable);
		
		List<PostEntity> posts = pagePosts.getContent();
		
		List<PostDto> myposts = posts.stream().map(post-> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		postResponse.setContent(myposts);
		postResponse.setPageNumber(pagePosts.getNumber());
		postResponse.setPageSize(pagePosts.getSize());
		postResponse.setTotalPages(pagePosts.getTotalPages());
		postResponse.setLastPage(pagePosts.isLast());
		
		
		return postResponse;
	}

	@Override
	public void savePost(PostDto post, int user_id, int cat_id) {
		
		if(post.equals(null) || post == null)
		{
			throw new MyException("post is empty","please fill all the feilds", HttpStatus.BAD_REQUEST);
		}
		
		UserEntity userEntity = this.userRepo.findById(user_id).orElseThrow(() -> new MyException("user", "not found",HttpStatus.NOT_FOUND));
		
		CategoryEntity categoryEntity = this.categoryRepo.findById(cat_id).orElseThrow(() -> new MyException("user", "not found",HttpStatus.NOT_FOUND));
		
		PostEntity postEntity =  this.dtoToPost(post);
		
		postEntity.setCategory(categoryEntity);
		postEntity.setUser(userEntity);
		postEntity.setImage("default.png");
		postEntity.setComment(null);
		
		this.postRepo.save(postEntity);
		
	}
	
	@Override
	public void deletePost(int post_id) {
		
	PostEntity postEntity =	this.postRepo.findById(post_id).orElseThrow();
		this.postRepo.delete(postEntity);
	}

	@Override
	public void updatePost(int post_id) {
		// TODO Auto-generated method stub
		PostEntity post = this.postRepo.findById(post_id).orElseThrow();
		this.postRepo.save(post);
		
	}
	
	@Override
	public List<PostDto> getCatPost(int cat_id) {
		
		Optional<CategoryEntity> categoryesOpt = 	this.categoryRepo.findById(cat_id);
		CategoryEntity category =  categoryesOpt.get();
		
		List<PostEntity> posts = 	this.postRepo.findByCategory(category);
		
	List<PostDto> myPostDtos = 	posts.stream().map(post-> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return myPostDtos;
	}
	
	
	public PostDto postToDto(PostEntity postEntity) {
		
		PostDto postDto =  modelMapper.map(postEntity, PostDto.class);

		return postDto;
	}
	
	public PostEntity dtoToPost(PostDto postDto)
	{
		PostEntity postEntity =  modelMapper.map(postDto, PostEntity.class);
		
		return postEntity;
	}

	

	
		
}
