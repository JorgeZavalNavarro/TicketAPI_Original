
package com.enlacetpe.ticketapi.repositoryTicketApiSD;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.modelTicketApiSD.CatZCiudadesModel;

@Repository
public interface CatZCiudadesRepository extends JpaRepository<CatZCiudadesModel, Long> {

	public CatZCiudadesModel findBySymAndDeleteFlag(String ciudad, Integer activo);

}
