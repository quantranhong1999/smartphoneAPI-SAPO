package com.smartphone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartphone.entity.CategoryEntity;
import com.smartphone.entity.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	ProductEntity findOneByVariant(String variantName);
	
	
}
