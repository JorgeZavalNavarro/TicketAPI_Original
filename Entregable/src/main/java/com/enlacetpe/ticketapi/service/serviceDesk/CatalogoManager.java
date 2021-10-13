package com.enlacetpe.ticketapi.service.serviceDesk;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlacetpe.ticketapi.model.SdmCaContactModel;
import com.enlacetpe.ticketapi.model.SdmCaOrganizationModel;
import com.enlacetpe.ticketapi.model.SdmCrStatModel;
import com.enlacetpe.ticketapi.model.SdmZDiagnosticoModel;
import com.enlacetpe.ticketapi.model.SdmZRegciuModel;
import com.enlacetpe.ticketapi.model.SdmZSolucionModel;
import com.enlacetpe.ticketapi.repository.SdmCaContactRepository;
import com.enlacetpe.ticketapi.repository.SdmCaOrganizationRepository;
import com.enlacetpe.ticketapi.repository.SdmCrStatRepository;
import com.enlacetpe.ticketapi.repository.SdmZDiagnosticoRepository;
import com.enlacetpe.ticketapi.repository.SdmZRegciuRepository;
import com.enlacetpe.ticketapi.repository.SdmZSolucionRepository;
import com.enlacetpe.ticketapi.response.CAOrganizationCatalogo;
import com.enlacetpe.ticketapi.response.CAStatus;
import com.enlacetpe.ticketapi.response.CACatalogo;

@Service
public class CatalogoManager {
	
	@Autowired
	private SdmCrStatRepository sdmCrStatRepository;

	@Autowired
	private SdmZRegciuRepository sdmZRegciuRepository;
	
	@Autowired
	private SdmZDiagnosticoRepository sdmZDiagnosticoRepository;
	
	@Autowired
	private SdmZSolucionRepository sdmZSolucionRepository;
	
	@Autowired
	private SdmCaOrganizationRepository sdmCaOrganizationRepository;
	
	@Autowired
	private SdmCaContactRepository sdmCaContactRepository;
	
	
	public List<CAStatus> catStatus() {
		List<CAStatus> responseList = new ArrayList<CAStatus>();
		List<SdmCrStatModel> catalogo = sdmCrStatRepository.findAll();
		if(!catalogo.isEmpty()) {
			for(SdmCrStatModel entity:catalogo) {
				CAStatus pojo = new CAStatus();
				if(entity.getId() != null) {
					pojo.setId(entity.getId());
				}
				if(entity.getPersid()!= null) {
					pojo.setPersid(entity.getPersid());
				}
				if(entity.getDel()!= null) {
					pojo.setDel(entity.getDel());
				}
				if(entity.getSym()!= null) {
					pojo.setSym(entity.getSym());
				}
				if(entity.getDescription()!= null) {
					pojo.setDescription(entity.getDescription());
				}
				if(entity.getCode()!= null) {
					pojo.setCode(entity.getCode());
				}
				if(entity.getActive()!= null) {
					pojo.setActive(entity.getActive());
				}
				
				responseList.add(pojo);
			}
		}
		return responseList;	
	}
	

	public List<CACatalogo> catRegCiudad(){
		List<CACatalogo> responseList = new ArrayList<CACatalogo>();
		try {
			List<SdmZRegciuModel> regiones =  sdmZRegciuRepository.findRegiones();
				for(SdmZRegciuModel registro: regiones) {
					CACatalogo ciuReg = new CACatalogo();
					ciuReg.setId(String.valueOf(registro.getId()));
					ciuReg.setSym(registro.getSym());
					responseList.add(ciuReg);
				}
				
		}catch(Exception ex) {
			System.out.println("Error en catalogo ciudadRegion" + ex);
		}
		return responseList;
		
	}
	
	
	
	public List<CACatalogo> catDiagnostico(){
		List<CACatalogo> responseList = new ArrayList<CACatalogo>();
		try {
			 List<SdmZDiagnosticoModel> diagnosticoList =  sdmZDiagnosticoRepository.findDiagnostico();
				for(SdmZDiagnosticoModel registro: diagnosticoList) {
					CACatalogo diagnostico = new CACatalogo();
					diagnostico.setId(String.valueOf(registro.getId()));
					diagnostico.setSym(registro.getSym());
					responseList.add(diagnostico);
				}
				
		}catch(Exception ex) {
			System.out.println("Error en catalogo ciudadRegion" + ex);
		}
		return responseList;
		
	}
	
	public List<CACatalogo> caSolucion(String id){
		List<CACatalogo> responseList = new ArrayList<CACatalogo>();
		try {
			List<SdmZSolucionModel> solucionList =  sdmZSolucionRepository.findByDiagnosticoIdAndDel(Integer.valueOf(id), 0);
			if(!solucionList.isEmpty()) {
				for(SdmZSolucionModel registro: solucionList) {
					CACatalogo solucion = new CACatalogo();
					solucion.setId(String.valueOf(registro.getId()));
					solucion.setSym(registro.getSym());
					responseList.add(solucion);
				}
			}
				
		}catch(Exception ex) {
			System.out.println("Error en catalogo ciudadRegion" + ex);
		}
		return responseList;
		
	}
	
	
	public List<CAOrganizationCatalogo> caOrganizaciones(){
		List<CAOrganizationCatalogo> responseList = new ArrayList<CAOrganizationCatalogo>();
		try {
			List<SdmCaOrganizationModel> oganizationList =  sdmCaOrganizationRepository.findByInactive(0);
			if(!oganizationList.isEmpty()) {
				for(SdmCaOrganizationModel registro: oganizationList) {
					CAOrganizationCatalogo organization = new CAOrganizationCatalogo();
					organization.setOrganizationUuid(registro.getOrganizationUuid());
					organization.setOrgName(registro.getOrgName());
					organization.setIdItsm(registro.getAbbreviation());
					responseList.add(organization);
				}
			}
				
		}catch(Exception ex) {
			System.out.println("Error en catalogo de organizaciones" + ex);
		}
		return responseList;
		
	}
	
	
	public List<CACatalogo> caGroup(String type){
		List<CACatalogo> responseList = new ArrayList<CACatalogo>();
		try {
			String typeGroup = type+"%";
			List<SdmCaContactModel> groupList =  sdmCaContactRepository.findByContactTypeAndLastNameLikeAndInactive(2308, typeGroup,0);
			if(!groupList.isEmpty()) {
				for(SdmCaContactModel registro: groupList) {
					CACatalogo catalogo = new CACatalogo();
					catalogo.setId(registro.getContactUuid());
					catalogo.setSym(registro.getLastName());
					responseList.add(catalogo);
				}
			}
				
		}catch(Exception ex) {
			System.out.println("Error en catalogo grupos" + ex);
		}
		return responseList;
		
	}
	
	public List<CACatalogo> caGroupAll(){
		List<CACatalogo> responseList = new ArrayList<CACatalogo>();
		try {
			List<SdmCaContactModel> groupList =  sdmCaContactRepository.findByContactTypeAndInactive(2308,0);
			if(!groupList.isEmpty()) {
				for(SdmCaContactModel registro: groupList) {
					CACatalogo catalogo = new CACatalogo();
					catalogo.setId(registro.getContactUuid());
					catalogo.setSym(registro.getLastName());
					responseList.add(catalogo);
				}
			}
				
		}catch(Exception ex) {
			System.out.println("Error en catalogo grupos" + ex);
		}
		return responseList;
		
	}

}
