package com.smartphone.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartphone.converter.CategoryConverter;
import com.smartphone.dto.CategoryDTO;
import com.smartphone.entity.CategoryEntity;
import com.smartphone.repository.CategoryRepository;
import com.smartphone.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	//Them moi hoac cap nhat san pham
	@Override
	public CategoryDTO saveCategory(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		
		
		if (categoryRepository.findOneByName(dto.getCategoryName()) == null) {
			if (dto.getId() != null) {
				CategoryEntity oldCategoryEntity = categoryRepository.findOne(dto.getId());
				entity = categoryConverter.toEntity(dto, oldCategoryEntity);
			} else {
				entity = categoryConverter.toEntity(dto, entity);
				entity.setCreateDate(new Date(System.currentTimeMillis()));
			}
			entity.setModifiedDate(new Date(System.currentTimeMillis()));
			
			return categoryConverter.toDTO(categoryRepository.save(entity));
		} else return null;
	}

	//Xoa Category
	@Override
	public void deleteCategory(Long id) {
		categoryRepository.delete(id);
		
	}
}
