package com.dropdownajex.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dropdownajex.dto.CommentDto;
import com.dropdownajex.entity.CommentEntity;
import com.dropdownajex.entity.PostEntity;
import com.dropdownajex.entity.UserEntity;
import com.dropdownajex.exception.MyException;
import com.dropdownajex.repository.CommentRepo;
import com.dropdownajex.repository.PostRepo;
import com.dropdownajex.repository.UserRepo;


@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	CommentRepo commentRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PostRepo postRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public void saveComments(CommentDto comments,int user_id,int post_id) {
		
		if(comments.equals(null) || user_id == 0 || post_id ==0 )
		{
			throw new MyException("comments can not be empty", "insufficent data", HttpStatus.BAD_REQUEST);
		}
		
		UserEntity userEntity =  userRepo.findById(user_id).orElseThrow();
		
		PostEntity postEntity = postRepo.findById(post_id).orElseThrow();
		
		
		
		CommentEntity myComment = modelMapper.map(comments, CommentEntity.class);
		
		myComment.setUser(userEntity);
		myComment.setPost(postEntity);
	
		this.commentRepo.save(myComment);
	}

	@Override
	public List<CommentDto> showComments() {
		
	List<CommentEntity> commentEntities = this.commentRepo.findAll();
	
	List<CommentDto> commentDtos = 	commentEntities.stream().map(com-> modelMapper.map(com, CommentDto.class)).collect(Collectors.toList());
	
	return commentDtos;
	}

}
