package com.enlacetpe.ticketapi.service.CMDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlacetpe.ticketapi.model.SdmCaContactModel;
import com.enlacetpe.ticketapi.model.SdmProbCtgModel;
import com.enlacetpe.ticketapi.repository.SdmCaContactRepository;
import com.enlacetpe.ticketapi.repository.SdmProbCtgRepository;
import com.enlacetpe.ticketapi.request.CategoryRequest;
import com.enlacetpe.ticketapi.response.CACategory;
import com.enlacetpe.ticketapi.response.CACategoryList;

@Service
public class CategoryManager {
	
	@Autowired
	private SdmProbCtgRepository sdmProbCtgRepository;
	
	@Autowired
	private SdmCaContactRepository sdmCaContactRepository;
		
	
	public CACategoryList getCategoryByType(CategoryRequest request) {
		DateTime initial = new DateTime();
		ArrayList<CACategory> categories = null;
		Boolean success = true;
		String error = null;
		String mssg = null;
		
		try {
			List<SdmCaContactModel> contact = sdmCaContactRepository.findByContactTypeAndLastNameLikeAndInactive(2308, "%"+request.getType()+"%",0);
			List<String> idContact = new ArrayList<String>();
			for(SdmCaContactModel idGrupo :contact) {
				idContact.add(idGrupo.getContactUuid());
			}
			
			if(!idContact.isEmpty()) {
				List<SdmProbCtgModel> listCategoria = sdmProbCtgRepository.findByGroupIdInAndDel(idContact,0);
				if(!listCategoria.isEmpty()) {
					categories= new ArrayList<CACategory>();
					for(SdmProbCtgModel model:listCategoria) {
						CACategory pojo= new CACategory();
						pojo.setId(model.getId().toString());
						pojo.setSym(model.getSym());
						pojo.setDescription(model.getDescription());
						pojo.setTenant(model.getTenant());
						pojo.setSsSym(model.getSsSym());
						if(model.getLastModDt() !=null) {
							pojo.setLastModDt(model.getLastModDt().toString());
						}else {
							pojo.setLastModDt(" ");
						}
						categories.add(pojo);
					}
				}
			}
			
		} catch (Exception e) {
			success = false;
			mssg = "Categoria:Ocurrio un error al consultar las categorias";
			error = e.toString();			
		}	
		Period period = new Period(initial, new DateTime());
		if(categories != null) {
			Collections.sort(categories, new Comparator<CACategory>() {
				@Override
				public int compare(CACategory arg0, CACategory arg1) {
					return arg0.getSym().compareTo(arg1.getSym());
				}
			 });
			return new CACategoryList(success, period, error, mssg, categories.size(), categories);
		}else { 
			return new CACategoryList(success, period, error, 0);
		}	
	}	
	
	
	
	
	public CACategoryList getCategoryByType2(CategoryRequest request) {
		DateTime initial = new DateTime();
		ArrayList<CACategory> categories = null;
		Boolean success = true;
		String error = null;
		String mssg = null;
		
		try {
			categories= new ArrayList<CACategory>();
			List<Object> listCategoria = null;
			if(request.getType().equalsIgnoreCase("CARE")) {
				listCategoria = sdmProbCtgRepository.getCategoriesCare();
			}else if(request.getType().equalsIgnoreCase("NOC")) {
				listCategoria = sdmProbCtgRepository.getCategoriesNoc();
			}
			
			if(!listCategoria.isEmpty()) {
				for(Object obj: listCategoria) {
					CACategory pojo= new CACategory();
					Object[] objeto = (Object[]) obj;
					String id = String.valueOf(objeto[0]);
					String sym = String.valueOf(objeto[1]);
					String tenant = String.valueOf(objeto[2]);
					String ssSym = String.valueOf(objeto[3]);
					String lastDateMod = String.valueOf(objeto[4]);
					
					pojo.setId(id);
					pojo.setSym(sym);
					pojo.setTenant(tenant);
					pojo.setSsSym(ssSym);
					pojo.setLastModDt(lastDateMod);
					categories.add(pojo);
					
				}
			}	
		} catch (Exception e) {
			success = false;
			mssg = "Categoria:Ocurrio un error al consultar las categorias";
			error = e.toString();			
		}	
		Period period = new Period(initial, new DateTime());
		if(categories != null) {
			Collections.sort(categories, new Comparator<CACategory>() {
				@Override
				public int compare(CACategory arg0, CACategory arg1) {
					return arg0.getSym().compareTo(arg1.getSym());
				}
			 });
			return new CACategoryList(success, period, error, mssg, categories.size(), categories);
		}else { 
			return new CACategoryList(success, period, error, 0);
		}	
	}	
}
