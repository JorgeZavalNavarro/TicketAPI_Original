package com.enlacetpe.ticketapi.repositoryTicketApiSD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.enlacetpe.ticketapi.modelTicketApiSD.BitacoraPeticionesModel;

@Repository
public interface BitacoraPeticionesRepository extends JpaRepository<BitacoraPeticionesModel, Long> {

	@Modifying
	@Query(value = "insert into bitacora_peticiones (nombre_Operador,numero_Empleado_TPoperador,fecha_envio_peticion,accion,json_request,json_response) VALUES (:nombreOperador,:numeroEmpleadoTPoperador,:fechaSolicitud,:accion,:jsonRequest,:jsonResponse)", nativeQuery = true)
	@Transactional
	public int insertarBitacora(@Param("nombreOperador") String nombreOperador,
			@Param("numeroEmpleadoTPoperador") String numeroEmpleadoTPoperador,
			@Param("fechaSolicitud") String fechaSolicitud, @Param("accion") String accion, @Param("jsonRequest") String jsonRequest,@Param("jsonResponse") String jsonResponse);

}
