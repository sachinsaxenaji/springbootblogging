package com.dropdownajex.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PostEntity {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Integer post_id;
	
	@Column
	private String title;
	
	@Column
	private String containt;
	
	@Column
	private String image;
	
	@JsonIgnore
	@ManyToOne
	private CategoryEntity category;
	
	@JsonIgnore
	@ManyToOne
	private UserEntity user;
	

	@JsonIgnore
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CommentEntity> comment = new ArrayList<>();
	
	


	public PostEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PostEntity(Integer post_id, String title, String containt, String image, CategoryEntity category,
			UserEntity user, List<CommentEntity> comment) {
		super();
		this.post_id = post_id;
		this.title = title;
		this.containt = containt;
		this.image = image;
		this.category = category;
		this.user = user;
		this.comment = comment;
	}


	public Integer getPost_id() {
		return post_id;
	}


	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContaint() {
		return containt;
	}


	public void setContaint(String containt) {
		this.containt = containt;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public CategoryEntity getCategory() {
		return category;
	}


	public void setCategory(CategoryEntity category) {
		this.category = category;
	}


	public UserEntity getUser() {
		return user;
	}


	public void setUser(UserEntity user) {
		this.user = user;
	}


	public List<CommentEntity> getComment() {
		return comment;
	}


	public void setComment(List<CommentEntity> comment) {
		this.comment = comment;
	}
	
	
	

}
