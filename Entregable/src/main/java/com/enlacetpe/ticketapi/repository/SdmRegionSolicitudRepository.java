package com.enlacetpe.ticketapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.model.SdmZRegionModel;

@Repository
public interface SdmRegionSolicitudRepository extends JpaRepository<SdmZRegionModel, Long> {

	@Query(value = "SELECT id,description \r\n" + 
			"FROM sdm_zregion \r\n" + 
			"where del = 0 \r\n" + 
			"and sym = :datoBusqueda ", nativeQuery = true)
	public List<Object> getRegionSolicitud(@Param("datoBusqueda") String datoBusqueda);

}
