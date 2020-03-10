package com.smartphone.converter;

import org.springframework.stereotype.Component;

import com.smartphone.dto.CategoryDTO;
import com.smartphone.dto.VersionDTO;
import com.smartphone.entity.CategoryEntity;
import com.smartphone.entity.VersionEntity;

@Component
public class CategoryConverter {

	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO dto = new CategoryDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setCategoryName(entity.getName());
		return dto;
	}
	
	public CategoryEntity toEntity(CategoryDTO newCategory, CategoryEntity oldCategoryEntity) {
		
		oldCategoryEntity.setName(newCategory.getCategoryName());
		
		return oldCategoryEntity;
	}
}
