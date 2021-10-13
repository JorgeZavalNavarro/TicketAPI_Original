package com.enlacetpe.ticketapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.model.SdmImpactModel;


@Repository
public interface SdmImpactRepository extends JpaRepository<SdmImpactModel, Long>{
	
	public SdmImpactModel findByEnumImpact(int enumImpact);
	
	public int countByEnumImpactAndDel(int enumImpact, int del);
	
	public SdmImpactModel findByEnumImpactAndDel(int enumImpact, int del);
}
