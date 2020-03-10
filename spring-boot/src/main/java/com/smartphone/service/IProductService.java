package com.smartphone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartphone.dto.ProductDTO;


@Service
public interface IProductService {
	ProductDTO save(ProductDTO dto);
	
	ProductDTO findById(Long id);
	
	List<ProductDTO> saveAll(List<ProductDTO> dtos);

	List<ProductDTO> findAll(Long... ids);

	ProductDTO update(ProductDTO newProduct);
	
	public void deleteProduct(Long id);
}
