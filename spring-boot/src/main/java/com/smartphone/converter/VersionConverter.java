package com.smartphone.converter;

import org.springframework.stereotype.Component;

import com.smartphone.dto.ProductDTO;
import com.smartphone.dto.VersionDTO;
import com.smartphone.entity.ProductEntity;
import com.smartphone.entity.VersionEntity;



@Component
public class VersionConverter {
	
	public VersionDTO toDTO(VersionEntity entity) {
		VersionDTO dto = new VersionDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		
		
		dto.setColor(entity.getColor());
		dto.setRom(entity.getRom());
		dto.setBattery(entity.getBattery());
		dto.setVersionName(dto.getColor().concat(" ").concat(dto.getRom()).concat(" ").concat(dto.getBattery()));
		return dto;
	}
	
	public VersionEntity toEntity(VersionDTO newVersion, VersionEntity oldVersionEntity) {
		oldVersionEntity.setColor(newVersion.getColor());
		oldVersionEntity.setRom(newVersion.getRom());
		oldVersionEntity.setBattery(newVersion.getBattery());
		oldVersionEntity.setName(newVersion.getColor().concat(" ").concat(newVersion.getRom()).concat(" ").concat(newVersion.getBattery()));
		
		return oldVersionEntity;
	}
}
