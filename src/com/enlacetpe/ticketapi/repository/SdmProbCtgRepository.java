package com.enlacetpe.ticketapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.model.SdmProbCtgModel;


@Repository
public interface SdmProbCtgRepository extends JpaRepository<SdmProbCtgModel, Long>{
	
	public List<SdmProbCtgModel> findByTenantAndDel(String tenant, Integer active);
	public List<SdmProbCtgModel> findByGroupIdInAndDel(List<String> idGrupo, Integer active);
	public SdmProbCtgModel findByPersid(String persid);
	public SdmProbCtgModel findById(Integer id);
	public SdmProbCtgModel findBySym(String nombre);
	
	@Query(value="select a.id,a.sym,a.tenant,a.ss_sym,a.last_mod_dt from sdm_prob_ctg a  \r\n" + 
			"left join sdm_ca_contact b on a.group_id = b.contact_uuid\r\n" + 
			"left join sdm_ca_tenant c on a.tenant = c.id\r\n" + 
			"where b.last_name like '%care%'\r\n" + 
			"and b.last_name not like 'CHG -%'\r\n" + 
			"and b.last_name not like 'REQ%' \r\n" + 
			"and a.del = 0\r\n" + 
			"group by a.sym  \r\n" + 
			"order by a.sym asc ",nativeQuery = true)
	public List<Object> getCategoriesCare ();
	
	
	@Query(value="\r\n" + 
			"select a.id,a.sym,a.tenant,a.ss_sym,a.last_mod_dt from sdm_prob_ctg a\r\n" + 
			"left join sdm_ca_contact b on a.group_id = b.contact_uuid \r\n" + 
			"where b.last_name in('NOC TPE SOPORTE N2','NOC TPE SOPORTE N2 MIDE','NOC TPE SOPORTE N1')\r\n" + 
			"group by a.sym\r\n" + 
			"order by b.last_name asc ",nativeQuery = true)
	public List<Object> getCategoriesNoc();
	
	
	
	
}
