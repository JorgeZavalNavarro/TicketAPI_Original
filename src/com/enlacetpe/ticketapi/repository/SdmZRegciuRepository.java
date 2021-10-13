package com.enlacetpe.ticketapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enlacetpe.ticketapi.model.SdmZRegciuModel;

public interface SdmZRegciuRepository extends JpaRepository<SdmZRegciuModel, Long>{
	
	public List<SdmZRegciuModel> findRegiones();
	
}


	
