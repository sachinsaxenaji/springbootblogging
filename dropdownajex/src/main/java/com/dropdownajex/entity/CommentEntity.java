package com.dropdownajex.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class CommentEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer  comment_id;
	
	@Column
	private String comment;
	
	@JsonIgnore
	@ManyToOne
	private UserEntity user;
	
	@JsonIgnore
	@ManyToOne
	private PostEntity post;
}
