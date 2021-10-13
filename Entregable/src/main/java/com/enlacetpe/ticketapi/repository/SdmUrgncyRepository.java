package com.enlacetpe.ticketapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.model.SdmUrgncyModel;

@Repository
public interface SdmUrgncyRepository extends JpaRepository<SdmUrgncyModel, Long> {

	public SdmUrgncyModel findByEnumImpact(int enumImpact);
	
	public int countByEnumImpactAndDel(int enumImpact, int del);

	public SdmUrgncyModel findByEnumImpactAndDel(int enumImpact, int del);
}
