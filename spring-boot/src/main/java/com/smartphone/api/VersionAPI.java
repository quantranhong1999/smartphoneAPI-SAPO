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
import com.smartphone.dto.VersionDTO;
import com.smartphone.service.IVersionService;
import com.smartphone.service.impl.VersionService;


@Repository
@RestController
public class VersionAPI {
	@Autowired
	private IVersionService versionService;
	
	// POST /api/version
	@PostMapping(value = "/api/version")
	public VersionDTO saveVersion(@RequestBody VersionDTO dto) {
		return versionService.save(dto);
	}
	
	// PUT /api/version/{id}
	@PutMapping(value = "/api/version/{id}")
	public VersionDTO updateVersion(@RequestBody VersionDTO dto, @PathVariable("id") Long id) {
		dto.setId(id);
		return versionService.save(dto);
	}
	// DELETE /api/products/{id}
	@DeleteMapping(value = "/api/version/{id}")
	public void deleteVersion(@PathVariable("id") Long id) {
		   versionService.deleteVersion(id);
	}
}
