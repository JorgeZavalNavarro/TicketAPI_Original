package com.enlacetpe.ticketapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.enlacetpe.ticketapi.model.SdmCaTenantModel;


@Repository
@Transactional
public interface SdmCaTenantRepository extends JpaRepository<SdmCaTenantModel, Long>{
	
	public SdmCaTenantModel findByName(String name);
	public SdmCaTenantModel findById(String id);
}
