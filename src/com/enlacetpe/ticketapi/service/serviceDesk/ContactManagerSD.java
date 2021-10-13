package com.enlacetpe.ticketapi.service.serviceDesk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlacetpe.ticketapi.model.SdmCaContactModel;
import com.enlacetpe.ticketapi.model.SdmCaLocationModel;
import com.enlacetpe.ticketapi.model.SdmCaOrganizationModel;
import com.enlacetpe.ticketapi.repository.SdmCaContactRepository;
import com.enlacetpe.ticketapi.repository.SdmCaLocationRepository;
import com.enlacetpe.ticketapi.repository.SdmCaOrganizationRepository;
import com.enlacetpe.ticketapi.response.CAContact;
import com.enlacetpe.ticketapi.response.CAContactList;
import com.enlacetpe.ticketapi.util.ReturnValor;

@Service
public class ContactManagerSD {
	
	@Autowired
	private SdmCaContactRepository sdmCaContactRepository;
	
	@Autowired
	private SdmCaOrganizationRepository sdmCaOrganizationRepository;
	
	@Autowired
	private SdmCaLocationRepository sdmCaLocationRepository;
	

	
	public CAContactList getContact(String option, String value) {
		DateTime initial = new DateTime();
		ArrayList<CAContact> contacts = null;
		Boolean success = true;
		String error = null;
		String mssg = "Contacto: Exito al conseguir los datos";
		try {		
			if(option.equalsIgnoreCase("organization")) {
				SdmCaOrganizationModel organizationModel = sdmCaOrganizationRepository.findByOrganizationUuid(value);
				if(organizationModel != null) {
					if(organizationModel.getInactive() == 0) {
						List<SdmCaContactModel> listOrganization = sdmCaContactRepository.findByOrganizationUuid(value);
						contacts = mapper(listOrganization);
					}else {
						mssg = "Contacto: La organizacion otorgada no esta activa...";
						success= false;
					}	
				}
			}
			
		} catch (Exception e) {
			success = false;
			error = e.toString();
		} 
		Period period = new Period(initial, new DateTime());
		if(contacts != null ) {
			Collections.sort(contacts, new Comparator<CAContact>() {
				@Override
				public int compare(CAContact arg0, CAContact arg1) {
					return arg0.getLastName().compareTo(arg1.getLastName());
				}
			 });
			return new CAContactList(success, period, error, mssg, contacts.size(), contacts);
		}else { 
			mssg="Contacto: No se encontraron contactos para la organizacion";
			return new CAContactList(success, period, error,mssg, 0);
		}
	}
	
	
	private ArrayList<CAContact> mapper(List<SdmCaContactModel> contacts){
		ArrayList<CAContact> contact = new ArrayList<CAContact>();
		for (SdmCaContactModel entity : contacts) {
			
			if(entity.getInactive() != null) {
				if(entity.getInactive()==0) {
					CAContact pojo = new CAContact();
					pojo.setMiddleName(entity.getMiddleName());
					pojo.setAlias(entity.getAlias());
					pojo.setFirstName(entity.getFirstName());
					pojo.setLastName(entity.getLastName());
					if(entity.getLastName()!=null)
					pojo.setComboName(ReturnValor.returnValor(entity.getLastName()) + "," + ReturnValor.returnValor(entity.getFirstName()) +" "+ ReturnValor.returnValor(entity.getMiddleName()));
					pojo.setPhoneNumber(entity.getPriPhoneNumber());
					pojo.setEmailAddress(entity.getEmailAddress());
					if(entity.getLocationUuid() != null) {
						SdmCaLocationModel locationEntity = sdmCaLocationRepository.findByLocationUuid(entity.getLocationUuid());
						if(locationEntity != null) {
							pojo.setLocationName(locationEntity.getLocationName());
							pojo.setLocationAddress1(locationEntity.getAddress1());
							pojo.setLocationAddress2(locationEntity.getAddress2());
							pojo.setLocationAddress3(locationEntity.getAddress3());
							pojo.setLocationCity(locationEntity.getCity());
							pojo.setLocationZip(locationEntity.getZip());
						}
					}
					if (entity.getCreationDate() != null) {
						pojo.setCreationDate(String.valueOf(entity.getCreationDate()));
					} else {
						pojo.setCreationDate(null);
					}
					if (entity.getLastUpdateDate() != null) {
						pojo.setLastModDate(String.valueOf(entity.getLastUpdateDate()));
					} else {
						pojo.setLastModDate(null);
					}
					pojo.setUserId(entity.getUserid());
					pojo.setTenant(entity.getTenant());
					if (entity.getInactive() != null) {
						pojo.setDeleteFlag(String.valueOf(entity.getInactive()));
					} else {
						pojo.setDeleteFlag(null);
					}
					if(entity.getOrganizationUuid() != null) {
						SdmCaOrganizationModel organizationModel = sdmCaOrganizationRepository.findByOrganizationUuid(entity.getOrganizationUuid());
						if(organizationModel != null) {
							pojo.setOrgName(organizationModel.getOrgName());
						}
					}
					contact.add(pojo);
					
				}
			}
	
		}

		return contact;
	}
	
	
	
	
	
	
}
