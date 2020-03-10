package com.smartphone.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smartphone.dto.CategoryDTO;

import com.smartphone.service.ICategoryService;

@RestController
public class CategoryAPI {
	@Autowired
	private ICategoryService categoryService;
	
	// POST /api/category
	@PostMapping(value = "/api/category")
	public CategoryDTO saveCategory(@RequestBody CategoryDTO dto) {
		return categoryService.saveCategory(dto);
	}
	
	// PUT /api/category/{id}
	@PutMapping(value = "/api/category/{id}")
	public CategoryDTO updateCategory(@RequestBody CategoryDTO dto, @PathVariable("id") Long id) {
		dto.setId(id);
		return categoryService.saveCategory(dto);
	}
	// DELETE /api/category/{id}
	@DeleteMapping(value = "/api/category/{id}")
	public void deleteCategory(@PathVariable("id") Long id) {
		categoryService.deleteCategory(id);
	}
}
