package com.enlacetpe.ticketapi.repositoryTicketApiSD;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.modelTicketApiSD.CatGruposModel;

@Repository
public interface CatGruposRepository extends JpaRepository<CatGruposModel, Long>{
	
	@Query(value="SELECT a.contact_uuid, a.last_name \r\n" + 
			"FROM db_ticketapisd.sdm_ca_contact a, db_ticketapisd.sdm_usp_contact b\r\n" + 
			"where a.contact_uuid = b.contact_uuid\r\n" + 
			"and a.contact_type =2308\r\n" + 
			"and b.zNivelAtencion_id not in (400001) \r\n" + 
			"and a.last_name like :grupo \r\n",nativeQuery = true)
	public List<Object> getGrupos(@Param("grupo") String grupo);
	
	
	
	public CatGruposModel findByLastName(String grupo);
	
}
