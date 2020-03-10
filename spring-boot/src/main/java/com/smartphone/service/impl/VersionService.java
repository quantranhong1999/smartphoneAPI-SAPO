package com.smartphone.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartphone.converter.VersionConverter;
import com.smartphone.dto.VersionDTO;

import com.smartphone.entity.VersionEntity;
import com.smartphone.repository.VersionRepository;
import com.smartphone.service.IVersionService;


@Service
public class VersionService implements IVersionService {
	@Autowired
	private VersionRepository versionRepository;
	@Autowired
	private VersionConverter versionConverter;
	
	//Them moi hoac cap nhat version
	@Override
	public VersionDTO save(VersionDTO dto) {
		VersionEntity entity = new VersionEntity();
		
		
		if (versionRepository.findOneByName(dto.getColor().concat(" ").concat(dto.getRom()).concat(" ").concat(dto.getBattery())) == null) {
			if (dto.getId() != null) {
				VersionEntity oldVersionEntity = versionRepository.findOne(dto.getId());
				entity = versionConverter.toEntity(dto, oldVersionEntity);
			} else {
				entity = versionConverter.toEntity(dto, entity);
				entity.setCreateDate(new Date(System.currentTimeMillis()));
			}
			entity.setModifiedDate(new Date(System.currentTimeMillis()));
			
			return versionConverter.toDTO(versionRepository.save(entity));
		} else return null;
	}
	
	//Xoa version
	@Override
	public void deleteVersion(Long id) {
		versionRepository.delete(id);
		
	}

}
