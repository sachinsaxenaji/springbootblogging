package com.dropdownajex.dto;
import javax.validation.constraints.NotEmpty;

import com.dropdownajex.entity.CategoryEntity;
import com.dropdownajex.entity.UserEntity;


public class PostDto {


	private Integer post_id;

	@NotEmpty(message = "title can not be empty")
	private String title;

	@NotEmpty(message = "containt can not be empty")
	private String containt;

	private String image;

	private CategoryEntity category;
	
	private UserEntity user;
	
	

	
	
	
	

	public PostDto(@NotEmpty(message = "id can not be empty") Integer post_id,
			@NotEmpty(message = "title can not be empty") String title,
			@NotEmpty(message = "containt can not be empty") String containt, String image, CategoryEntity category) {
		super();
		this.post_id = post_id;
		this.title = title;
		this.containt = containt;
		this.image = image;
		this.category = category;
	}
	
	

	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
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
	

}
