package com.smartphone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartphone.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findOneByName(String categoryName);
}
