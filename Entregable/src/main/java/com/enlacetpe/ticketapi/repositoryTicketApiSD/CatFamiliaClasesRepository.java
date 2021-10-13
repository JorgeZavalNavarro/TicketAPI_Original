
package com.enlacetpe.ticketapi.repositoryTicketApiSD;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.modelTicketApiSD.CatFamiliaClasesModel;

@Repository
public interface CatFamiliaClasesRepository extends JpaRepository<CatFamiliaClasesModel, Long> {

	@Query(value = "select id_familia_clase, nombre_familia_clase, activo from db_ticketapisd.cat_familia_clases where activo = 0", nativeQuery = true)
	public List<Object> getFamiliaClase();

}
