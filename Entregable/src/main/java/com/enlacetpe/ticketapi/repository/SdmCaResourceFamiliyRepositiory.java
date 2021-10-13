package com.enlacetpe.ticketapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.model.SdmCaResourceFamilyModel;

@Repository
public interface SdmCaResourceFamiliyRepositiory extends JpaRepository<SdmCaResourceFamilyModel, Long>{
	
	public SdmCaResourceFamilyModel findByNameAndInactive(String nombre, Integer inactive);

}
