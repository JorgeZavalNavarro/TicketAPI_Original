package com.enlacetpe.ticketapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.model.SdmCaContactModel;

@Repository
public interface SdmCaContactRepository extends JpaRepository<SdmCaContactModel, Long> {
	
	public List<SdmCaContactModel> findByOrganizationUuid(String organization);
	public List<SdmCaContactModel> findByFirstName(String firstName);
	public List<SdmCaContactModel> findByMiddleName (String middleName);
	public List<SdmCaContactModel> findByLastName(String lastName);
	public List<SdmCaContactModel> findByContactUuid (String contactUuid);
	public List<SdmCaContactModel> findByContactTypeAndLastNameLikeAndInactive(Integer contactType, String lastName,Integer inactive);
	public List<SdmCaContactModel> findByContactTypeAndInactive(Integer contactType,Integer inactive);
	
}
