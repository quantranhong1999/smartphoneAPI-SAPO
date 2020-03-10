package com.smartphone.service;

import org.springframework.stereotype.Service;

import com.smartphone.dto.CategoryDTO;



@Service
public interface ICategoryService {
	CategoryDTO saveCategory(CategoryDTO dto);
	public void deleteCategory(Long id);
	
}
