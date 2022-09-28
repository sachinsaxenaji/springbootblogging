package com.dropdownajex.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostResponse {

	private List<PostDto> content;
	private int pageNumber;
	private int pageSize;
	private int totlaElements;
	private int totalPages;
	private boolean isLastPage;	
	
}
