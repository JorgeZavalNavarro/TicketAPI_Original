package com.enlacetpe.ticketapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.model.SdmPriModel;

@Repository
public interface SdmPriRepository extends JpaRepository<SdmPriModel,Long>{
	
	public SdmPriModel findByEnumPri(int enumPri);

}
