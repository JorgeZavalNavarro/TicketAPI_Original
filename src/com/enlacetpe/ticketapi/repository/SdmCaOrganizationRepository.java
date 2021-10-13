package com.enlacetpe.ticketapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.model.SdmCaOrganizationModel;



@Repository
public interface SdmCaOrganizationRepository extends JpaRepository<SdmCaOrganizationModel, Long>{
	
	public SdmCaOrganizationModel findByOrganizationUuid(String organization);
	public SdmCaOrganizationModel findByOrgName(String nameOrganization);
	public SdmCaOrganizationModel findByAbbreviation(String abbrevation);
	public List<SdmCaOrganizationModel> findByOrgNameLikeAndInactive(String nombre,Integer inactive);
	public List<SdmCaOrganizationModel> findByInactive(Integer inactive);
	

}
