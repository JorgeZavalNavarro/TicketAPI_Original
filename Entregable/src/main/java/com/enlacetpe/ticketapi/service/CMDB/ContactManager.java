package com.enlacetpe.ticketapi.service.CMDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlacetpe.ticketapi.model.SdmBusmgtModel;
import com.enlacetpe.ticketapi.model.SdmCaOwnedResourceModel;
import com.enlacetpe.ticketapi.model.SdmCaTenantModel;
import com.enlacetpe.ticketapi.repository.SdmBusmgtRepository;
import com.enlacetpe.ticketapi.repository.SdmCaOwnedResourceRepository;
import com.enlacetpe.ticketapi.repository.SdmCaTenantRepository;
import com.enlacetpe.ticketapi.response.CAContact;
import com.enlacetpe.ticketapi.response.CAContactList;


@Service
public class ContactManager {
		
	@Autowired
	private SdmCaOwnedResourceRepository sdmCaOwnedResourceRepository;
	
	@Autowired
	private SdmBusmgtRepository sdmBusmgtRepository;
	
	@Autowired
	private SdmCaTenantRepository sdmCaTenantRepository;
	

	public CAContactList getContactCMDB(String option, String value) {
		DateTime initial = new DateTime();
		ArrayList<CAContact> contacts = null;
		Boolean success = true;
		String error = null;
		String mssg = "ContactoCMDB: Exito al conseguir los contactos";
		try {
			List<String> hijos = new ArrayList<String>();
			if(option.equalsIgnoreCase("organization")) {
				SdmCaOwnedResourceModel padre = sdmCaOwnedResourceRepository.findByResourceName(value);
				
				if(padre.getInactive() != null) {
					if(padre.getInactive() == 0) {
						List<SdmBusmgtModel> listaHijos = sdmBusmgtRepository.findByHierParent(padre.getOwnResourceUuid());
						for(SdmBusmgtModel entity: listaHijos) {
							hijos.add(entity.getHierChild());
						}
						if(!hijos.isEmpty()) {
							List<SdmCaOwnedResourceModel> listaPuntas = sdmCaOwnedResourceRepository.findByOwnResourceUuidInAndResourceClassNot(hijos,1000147);
							List<SdmCaOwnedResourceModel> listaONTs = sdmCaOwnedResourceRepository.findByOwnResourceUuidInAndResourceClass(hijos,1000147);
							contacts = mapperCMDB(listaPuntas,true);
							contacts.addAll(mapperCMDB(listaONTs,false));
							mssg = "ContactoCMDB:Exito al encontrar los contactos";
						}
					}else {
						mssg = "ContactoCMDB:La organizacion esta inactiva";
					}	
				}
			}
		} catch (Exception e) {
			success = false;
			error = e.toString();
		} 
		Period period = new Period(initial, new DateTime());
		if(contacts != null && contacts.size() > 0) {
			Collections.sort(contacts, new Comparator<CAContact>() {
				@Override
				public int compare(CAContact arg0, CAContact arg1) {
					return arg0.getComboName().compareTo(arg1.getComboName());
				}
			 });
			return new CAContactList(success, period, error, mssg, contacts.size(), contacts);
		}else { 
			mssg="ContactoCMDB:No se encontraron contactos para la organizacion";
			return new CAContactList(success, period, error,mssg, 0);
		}
	}
	
	
	private ArrayList<CAContact> mapperCMDB(List<SdmCaOwnedResourceModel> contacts, boolean isCi){
		ArrayList<CAContact> contact = new ArrayList<CAContact>();
		for(SdmCaOwnedResourceModel entity: contacts) {
			if(entity.getInactive() != null ) {
				if(entity.getInactive()==0) {
					CAContact pojo = new CAContact();
					pojo.setId(entity.getOwnResourceUuid());
					if(isCi) {
						pojo.setComboName(entity.getResourceName());
					}else {
						pojo.setComboName(entity.getHostName());
					}
					pojo.setHostName(entity.getHostName());
					pojo.setMacAddress(entity.getMacAddress());
					pojo.setIpAddress(entity.getIpAddress());
					pojo.setSerialNumber(entity.getSerialNumber());
					if(entity.getTenant() != null) {
						SdmCaTenantModel tenant = sdmCaTenantRepository.findById(entity.getTenant());
						if(tenant != null) {
							pojo.setTenant(tenant.getName());
						}
					}
					contact.add(pojo);
				}
			}		
		}
		return contact;
	}
	
	

}
