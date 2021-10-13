package com.enlacetpe.ticketapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.model.SdmZCiudadModel;

@Repository
public interface SdmCiudadSolicitudRepository extends JpaRepository<SdmZCiudadModel, Long> {
	
	@Query(value = "SELECT id,description \r\n" + 
			"FROM datahub.sdm_zciudad \r\n" + 
			"where del = 0 and \r\n" + 
			"sym = :datoBusqueda ", nativeQuery = true)
	public List<Object> getCiudadSolicitud(@Param("datoBusqueda") String datoBusqueda);

}
