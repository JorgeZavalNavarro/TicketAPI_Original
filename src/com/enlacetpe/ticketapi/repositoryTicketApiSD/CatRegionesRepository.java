package com.enlacetpe.ticketapi.repositoryTicketApiSD;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.modelTicketApiSD.CatRegionesModel;

@Repository
public interface CatRegionesRepository extends JpaRepository<CatRegionesModel, Long> {

	public CatRegionesModel findBySymAndDeleteFlag(String region, Integer activo);

	@Query(value = "SELECT r.id,c.sym \r\n" + 
			"FROM db_ticketapisd.sdm_zregciu r, db_ticketapisd.sdm_zciureg c\r\n" + 
			"where r.id = c.zregion_id\r\n" + 
			"and r.delete_flag = 0\r\n" + 
			"and c.zregion_id = ?1 ", nativeQuery = true)
	public List<Object> getCiudades(@Param("idRegion") String idRegion);

}
