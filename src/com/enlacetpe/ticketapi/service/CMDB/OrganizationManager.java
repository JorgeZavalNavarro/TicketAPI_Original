package com.enlacetpe.ticketapi.service.CMDB;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlacetpe.ticketapi.model.SdmCaOrganizationModel;
import com.enlacetpe.ticketapi.repository.SdmCaOrganizationRepository;
import com.enlacetpe.ticketapi.request.OrganizationRequest;
import com.enlacetpe.ticketapi.response.CAOrganization;
import com.enlacetpe.ticketapi.response.CAOrganizationList;

@Service
public class OrganizationManager {
	
	@Autowired
	private SdmCaOrganizationRepository sdmCaOrganizationRepository;
	
	public CAOrganizationList findOrganization(OrganizationRequest request) {
		DateTime initial = new DateTime();
		Boolean success = true;
		String error = null;
		List<CAOrganization> listaResponse = new ArrayList<CAOrganization>();
		try {
			if(!request.getId().isEmpty() && request.getName().isEmpty()) {
				listaResponse = getId(request.getId());
			}
			if(!request.getName().isEmpty() && request.getId().isEmpty()) {
				listaResponse = getCoincidencias(request.getName());
			}
			if(!request.getName().isEmpty() && !request.getId().isEmpty()) {
				listaResponse = getId(request.getId());
				listaResponse.addAll(getCoincidencias(request.getName()));
			}
			if(request.getName().isEmpty() && request.getId().isEmpty()) {
				success = false;
				error = "Se debe llenar algun dato";
			}
		}catch(Exception e) {
			success = false;
			error = e.toString();
		}
		Period period = new Period(initial, new DateTime());
		return new CAOrganizationList(success, period, error,listaResponse);
	}
	
	private List<CAOrganization> getId(String id) {
		List<CAOrganization> listaResponse = new ArrayList<CAOrganization>();
		SdmCaOrganizationModel organization = sdmCaOrganizationRepository.findByAbbreviation(id);
		if(organization != null) {
			if(organization.getInactive() != 0) {
				CAOrganization response = new CAOrganization();
				response.setId(organization.getAbbreviation());
				response.setName(organization.getOrgName());
				response.setActive(organization.getInactive());
				response.setMssg("Organizacion activa");
				listaResponse.add(response);
			}else {
				CAOrganization response = new CAOrganization();
				response.setId(organization.getAbbreviation());
				response.setName(organization.getOrgName());
				response.setActive(organization.getInactive());
				response.setMssg("Organizacion inactiva");
				listaResponse.add(response);
			}
		}else {
			CAOrganization response = new CAOrganization();
			response.setId(id);
			response.setName("");
			response.setActive(0);
			response.setMssg("Id no encontrado");
			listaResponse.add(response);
		}
		return listaResponse;
	}
	
	private List<CAOrganization> getCoincidencias(String name) {
		List<CAOrganization> listaResponse = new ArrayList<CAOrganization>();
		String nombre ='%'+name+'%';
		List<SdmCaOrganizationModel> listaOrg = sdmCaOrganizationRepository.findByOrgNameLikeAndInactive(nombre, 0);
		if(!listaOrg.isEmpty()) {
			for(SdmCaOrganizationModel entity:listaOrg) {
				CAOrganization response = new CAOrganization();
				response.setId(entity.getAbbreviation());
				response.setName(entity.getOrgName());
				response.setActive(entity.getInactive());
				response.setMssg("");
				listaResponse.add(response);
			}
		}
		return listaResponse;
	}
}
