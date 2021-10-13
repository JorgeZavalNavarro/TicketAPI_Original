package com.enlacetpe.ticketapi.repositoryTicketApiSD;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.modelTicketApiSD.CatCiudadesModel;

@Repository
public interface CatCiudadesRepository extends JpaRepository<CatCiudadesModel, Long>{
	
	@Query(value="SELECT id,sym FROM sdm_zregciu where sym like :datoBusqueda " ,nativeQuery = true)
	public List<Object> getCiudades(@Param("datoBusqueda") String datoBusqueda);
	
	
}
