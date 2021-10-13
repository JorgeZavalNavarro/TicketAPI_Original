package com.enlacetpe.ticketapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.model.SdmCaLocationModel;


@Repository
public interface SdmCaLocationRepository extends JpaRepository<SdmCaLocationModel, Long>{
	
	public SdmCaLocationModel findByLocationUuid(String locationId);
}
