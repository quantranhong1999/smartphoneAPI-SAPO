package com.smartphone.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.smartphone.dto.ProductDTO;
import com.smartphone.entity.ProductEntity;

@Component
public class ProductConverter {

	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity entity = new ProductEntity();
		entity.setName(dto.getProductName());
		entity.setQuantity(dto.getQuantity());
		return entity;
	}

	public ProductDTO toDTO(ProductEntity entity) {
		ProductDTO dto = new ProductDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		if (entity.getVersion() != null) {
			
			dto.setVersionName(entity.getVersion().getName());
		}
		if (entity.getCategory() != null) {
			dto.setCategoryName(entity.getCategory().getName());
		}
		
		dto.setCreateDate(entity.getCreateDate());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setQuantity(entity.getQuantity());
		dto.setProductName(entity.getName());
		dto.setColor(entity.getVersion().getColor());
		dto.setRom(entity.getVersion().getRom());
		dto.setBattery(entity.getVersion().getBattery());
		return dto;
	}

	public List<ProductEntity> toEntities(List<ProductDTO> dtos) {
		List<ProductEntity> entities = new ArrayList<ProductEntity>();
		for (ProductDTO dto : dtos) {
			entities.add(this.toEntity(dto));
		}
		return entities;
	}

	public List<ProductDTO> toDTOs(List<ProductEntity> entities) {
		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		for (ProductEntity entity : entities) {
			dtos.add(this.toDTO(entity));
		}
		return dtos;
	}
	//nếu id sản phẩm cho vào trùng id sản phẩm đã có thì tiến hành cập nhật sản phẩm
	public ProductEntity toEntity(ProductDTO newProduct, ProductEntity oldProductEntity) {
		oldProductEntity.setName(newProduct.getProductName());
		
		return oldProductEntity;
	}
}
