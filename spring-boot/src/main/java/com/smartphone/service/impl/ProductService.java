package com.smartphone.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartphone.converter.ProductConverter;
import com.smartphone.dto.ProductDTO;
import com.smartphone.entity.CategoryEntity;
import com.smartphone.entity.ProductEntity;
import com.smartphone.entity.VersionEntity;
import com.smartphone.repository.CategoryRepository;
import com.smartphone.repository.ProductRepository;
import com.smartphone.repository.VersionRepository;
import com.smartphone.service.IProductService;
import com.sun.xml.bind.v2.model.core.ID;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private VersionRepository versionRepository;

	@Autowired
	private ProductConverter productConverter;

	// Hàm thêm mới 1 sản phẩm
	@Override
	public ProductDTO save(ProductDTO productDTO) {
		ProductEntity entity = new ProductEntity();
		CategoryEntity categoryEntity = categoryRepository.findOneByName(productDTO.getCategoryName());
		VersionEntity versionEntity = versionRepository.findOneByName(productDTO.getVersionName());
		if (productRepository.findOneByVariant(productDTO.getProductName().concat(" ").concat(versionEntity.getName())) == null) {
			if (productDTO.getId() != null) {
				ProductEntity oldProductEntity = productRepository.findOne(productDTO.getId());
				entity = productConverter.toEntity(productDTO, oldProductEntity);
			} else {
				entity = productConverter.toEntity(productDTO, entity);
				entity.setCreateDate(new Date(System.currentTimeMillis()));
			}
			entity.setModifiedDate(new Date(System.currentTimeMillis()));
			
			
			entity.setVariant(productDTO.getProductName().concat(" ").concat(versionEntity.getName()));
			entity.setCategory(categoryEntity);
			entity.setVersion(versionEntity);
			entity.setQuantity(productDTO.getQuantity());
			return productConverter.toDTO(productRepository.save(entity));
		} else return null;
		
		
	}

	// Thêm mới nhiều sản phẩm
	@Override
	public List<ProductDTO> saveAll(List<ProductDTO> dtos) {
		List<ProductDTO> savedDTOs = new ArrayList<ProductDTO>();
		for (ProductDTO dto : dtos) {
			savedDTOs.add(this.save(dto));
		}
		return savedDTOs;
	}

	// lấy ra nhiều sản phẩm
	@Override
	public List<ProductDTO> findAll(Long... ids) {
		List<Long> idList = Arrays.asList(ids);
		return productConverter.toDTOs(productRepository.findAll(idList));
	}

	// Cập nhật sản phẩm(có thể dùng hàm save ở trên thay thế )
	@Override
	public ProductDTO update(ProductDTO newProduct) {
		ProductEntity oldProductEntity = productRepository.findOne(newProduct.getId());
		ProductEntity newProductEntity = productConverter.toEntity(newProduct, oldProductEntity);
		CategoryEntity categoryEntity = categoryRepository.findOneByName(newProduct.getCategoryName());
		VersionEntity versionEntity = versionRepository.findOneByName(newProduct.getVersionName());
		if (productRepository.findOneByVariant(newProduct.getProductName().concat(" ").concat(versionEntity.getName())) == null) {
			newProductEntity.setModifiedDate(new Date(System.currentTimeMillis()));
			
			newProductEntity.setVariant(newProduct.getProductName().concat(" ").concat(versionEntity.getName()));
			newProductEntity.setQuantity(newProduct.getQuantity());
			newProductEntity.setCategory(categoryEntity);
			newProductEntity.setVersion(versionEntity);
			return productConverter.toDTO(productRepository.save(newProductEntity));
		}
		else return null;
	}
	// Xóa sản phẩm theo id
	@Override
	public void deleteProduct(Long id) {
		productRepository.delete(id);

	}
	// Lấy ra thông tin 1 sản phẩm
	@Override
	public ProductDTO findById(Long id) {
		return productConverter.toDTO(productRepository.findOne(id));
	
	}

}
