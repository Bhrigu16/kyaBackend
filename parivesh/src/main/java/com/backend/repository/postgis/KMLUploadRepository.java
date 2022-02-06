package com.backend.repository.postgis;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.model.kmlFile;

public interface KMLUploadRepository extends JpaRepository<kmlFile, Integer> {

}
