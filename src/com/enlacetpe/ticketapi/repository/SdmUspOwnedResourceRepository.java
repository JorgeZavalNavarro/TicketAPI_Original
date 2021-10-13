package com.enlacetpe.ticketapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.model.SdmUspOwnedResourceModel;

@Repository
public interface SdmUspOwnedResourceRepository extends JpaRepository<SdmUspOwnedResourceModel, Long>{
	
	List<SdmUspOwnedResourceModel> findByZorgPropietaria(String organizacion);
	
	List<SdmUspOwnedResourceModel> findByOwnedResourceUuid(String ownedResourceUuid);

}
