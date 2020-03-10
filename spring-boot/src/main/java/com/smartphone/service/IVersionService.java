package com.smartphone.service;

import org.springframework.stereotype.Service;

import com.smartphone.dto.VersionDTO;

@Service
public interface IVersionService {
	VersionDTO save(VersionDTO dto);
	public void deleteVersion(Long id);
}
