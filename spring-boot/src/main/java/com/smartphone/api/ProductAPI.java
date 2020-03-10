package com.smartphone.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smartphone.dto.ProductDTO;
import com.smartphone.repository.ProductRepository;
import com.smartphone.service.IProductService;
@Repository
@RestController
public class ProductAPI {

	@Autowired
	private IProductService productService;

	// POST /api/product
	@PostMapping(value = "/api/product")
	public ProductDTO saveProductDTO(@RequestBody ProductDTO dto) {
		return productService.save(dto);
	}

	// POST /api/products
	@PostMapping(value = "/api/products")
	public List<ProductDTO> saveAllProductDTO(@RequestBody List<ProductDTO> dtos) {
		return productService.saveAll(dtos);
	}
	
	// GET /api/products/{id}
	@GetMapping(value = "/api/products/{id}")
	  public ProductDTO findById(@PathVariable Long id) {
		return productService.findById(id);
	    
	  }
	
	// GET /api/products
	@GetMapping(value = "/api/products")
	public List<ProductDTO> findAll(@RequestBody Long... ids) {
		return productService.findAll(ids);
	}

	// PUT /api/products/{id}
	@PutMapping(value = "/api/products/{id}")
	public ProductDTO update(@RequestBody ProductDTO dto, @PathVariable("id") Long id) {
		dto.setId(id);
		return productService.save(dto);
	}
	
	// DELETE /api/products/{id}
	@DeleteMapping(value = "/api/products/{id}")
	public void deleteProduct(@PathVariable("id") Long id) {
	     productService.deleteProduct(id);
	 }
	}

	

