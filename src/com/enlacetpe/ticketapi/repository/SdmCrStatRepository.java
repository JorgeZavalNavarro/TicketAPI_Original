package com.enlacetpe.ticketapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.model.SdmCrStatModel;



@Repository
public interface SdmCrStatRepository extends JpaRepository<SdmCrStatModel, Long>{
	
	public SdmCrStatModel findByCode(String persid);
	public SdmCrStatModel findBySymAndActive(String code, Integer active );
	public SdmCrStatModel findBySym(String nombre);

}
