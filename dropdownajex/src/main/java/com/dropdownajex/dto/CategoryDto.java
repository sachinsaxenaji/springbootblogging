package com.dropdownajex.dto;


import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
	
	
	@NotEmpty(message = "categoryId can not be empty")
	private Integer categoryId;
	
	@NotEmpty(message = "categoryTitle can not be empty")
	private String categoryTitle;
	
	@NotEmpty(message = "categoryDescription can not be empty")
	private String categoryDescription;
	

}
