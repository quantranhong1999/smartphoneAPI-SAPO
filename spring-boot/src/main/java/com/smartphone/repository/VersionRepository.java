package com.smartphone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartphone.entity.VersionEntity;

public interface VersionRepository extends JpaRepository<VersionEntity, Long> {

	VersionEntity findOneByName(String versionName);
}
