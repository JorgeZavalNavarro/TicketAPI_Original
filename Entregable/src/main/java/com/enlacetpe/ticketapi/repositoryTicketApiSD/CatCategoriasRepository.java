package com.enlacetpe.ticketapi.repositoryTicketApiSD;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enlacetpe.ticketapi.modelTicketApiSD.CatCategoriasModel;

@Repository
public interface CatCategoriasRepository extends JpaRepository<CatCategoriasModel, Long>{
	
	@Query(value="SELECT a.id,a.persid, a.sym,a.tenant,a.ss_sym FROM db_ticketapisd.sdm_prob_ctg a \r\n" + 
			"where a.in_flag = 1  \r\n" + 
			"and a.del = 0 \r\n" + 
			"and (a.sym LIKE '%ESTRATEGICOS%' OR \r\n" + 
			" a.sym LIKE '%TFE%' OR  \r\n" + 
			" a.sym LIKE '%GRUPO SALINAS%' OR \r\n" + 
			" a.sym LIKE '%GOBIERNO%' OR \r\n" + 
			" a.sym LIKE 'SERVICIO TÉCNICO%' OR \r\n" + 
			" a.sym LIKE '%EDUCACIÓN%' OR  \r\n" + 
			" a.sym LIKE '%OFERTA HOTELERA%' OR \r\n" + 
			" a.sym LIKE '%MONITOREO SMC PROACTIVO%' OR \r\n" + 
			" a.sym LIKE '%MONITOREO PROACTIVO%' OR \r\n" + 
			" a.sym LIKE '%SERVICIO DE DATOS CARRIERS%' OR  \r\n" + 
			" a.sym LIKE '%SERVICIO DE TELEFONÍA CARRIERS%' OR \r\n" + 
			" a.sym LIKE '%SERVICIOS CON TERCEROS CARRIERS%' OR \r\n" + 
			" a.pr_flag = 1  OR  \r\n" + 
			" a.sym LIKE 'SMC.%' OR \r\n" + 
			" a.sym LIKE 'Soporte Tecnico%' OR\r\n" + 
			" a.sym LIKE 'Alta Add-On.Servidor%' OR\r\n" + 
			" a.sym LIKE 'Cancelación.Servidor%' OR\r\n" + 
			" a.sym LIKE 'Downgrade Add-On.Servidor%' OR\r\n" + 
			" a.sym LIKE 'Soporte Técnico Servidores Virtuales.%' OR\r\n" + 
			" a.sym LIKE 'Upgrade Add-On.Servidor%' OR\r\n" + 
			" a.sym LIKE 'VIDEOVIGILANCIA.%' OR\r\n" + 
			" a.sym LIKE '%G-Suite%' OR\r\n" + 
			" a.sym LIKE 'AYUDA TÉCNICA.%' OR\r\n" + 
			" a.sym LIKE 'CONCIERGE.%' OR\r\n" + 
			" a.sym LIKE 'CORREO.%' OR\r\n" + 
			" a.sym LIKE 'NAVEGACION SEGURA.PROBLEMA%' OR\r\n" + 
			" a.sym LIKE 'WIFI ADMINISTRADO.%' OR\r\n" + 
			" a.sym LIKE 'ERP.%' OR\r\n" + 
			" a.sym LIKE 'PAGINA WEB.%' OR\r\n" + 
			" a.sym LIKE 'DOMINIO.%' OR\r\n" + 
			" a.sym LIKE 'EMAIL MARKETING.%' OR\r\n" + 
			" a.sym LIKE 'REDES SOCIALES.%' OR\r\n" + 
			" a.sym LIKE 'SOPORTE A PC RECOVERY.%' OR\r\n" + 
			" a.sym LIKE 'SOPORTE TÉCNICO A PC Y DISPOSITIVOS.%' OR\r\n" + 
			" a.sym LIKE 'SOPORTE A ENDPOINT SECURITY.%' OR\r\n" + 
			" a.sym LIKE 'FICHA GOOGLE MAPS.%' OR\r\n" + 
			" a.sym LIKE 'E-COMMERCE.%' OR\r\n" + 
			" a.sym LIKE 'CRM.%' OR\r\n" + 
			" a.sym LIKE 'SOPORTE A FLOTILLAS.%') \r\n" + 
			"and a.sym LIKE :datoBusqueda \r\n" + 
			"group by a.sym",nativeQuery = true)
	
	public List<Object> getCategoriesIncidentes(@Param("datoBusqueda") String datoBusqueda);
	
	@Query(value="SELECT a.id,a.persid, a.sym,a.tenant,a.ss_sym FROM db_ticketapisd.sdm_prob_ctg a \r\n" + 
			"where a.in_flag = 1  \r\n" + 
			"and a.del = 0 \r\n" + 
			"and (a.sym LIKE '%ESTRATEGICOS%' OR \r\n" + 
			" a.sym LIKE '%TFE%' OR  \r\n" + 
			" a.sym LIKE '%GRUPO SALINAS%' OR \r\n" + 
			" a.sym LIKE '%GOBIERNO%' OR \r\n" + 
			" a.sym LIKE 'SERVICIO TÉCNICO%' OR \r\n" + 
			" a.sym LIKE '%EDUCACIÓN%' OR  \r\n" + 
			" a.sym LIKE '%OFERTA HOTELERA%' OR \r\n" + 
			" a.sym LIKE '%MONITOREO SMC PROACTIVO%' OR \r\n" + 
			" a.sym LIKE '%MONITOREO PROACTIVO%' OR \r\n" + 
			" a.sym LIKE '%SERVICIO DE DATOS CARRIERS%' OR  \r\n" + 
			" a.sym LIKE '%SERVICIO DE TELEFONÍA CARRIERS%' OR \r\n" + 
			" a.sym LIKE '%SERVICIOS CON TERCEROS CARRIERS%' OR \r\n" + 
			" a.pr_flag = 1  OR  \r\n" + 
			" a.sym LIKE 'SMC.%' OR \r\n" + 
			" a.sym LIKE 'Soporte Tecnico%' OR\r\n" + 
			" a.sym LIKE 'Alta Add-On.Servidor%' OR\r\n" + 
			" a.sym LIKE 'Cancelación.Servidor%' OR\r\n" + 
			" a.sym LIKE 'Downgrade Add-On.Servidor%' OR\r\n" + 
			" a.sym LIKE 'Soporte Técnico Servidores Virtuales.%' OR\r\n" + 
			" a.sym LIKE 'Upgrade Add-On.Servidor%' OR\r\n" + 
			" a.sym LIKE 'VIDEOVIGILANCIA.%' OR\r\n" + 
			" a.sym LIKE '%G-Suite%' OR\r\n" + 
			" a.sym LIKE 'AYUDA TÉCNICA.%' OR\r\n" + 
			" a.sym LIKE 'CONCIERGE.%' OR\r\n" + 
			" a.sym LIKE 'CORREO.%' OR\r\n" + 
			" a.sym LIKE 'NAVEGACION SEGURA.PROBLEMA%' OR\r\n" + 
			" a.sym LIKE 'WIFI ADMINISTRADO.%' OR\r\n" + 
			" a.sym LIKE 'ERP.%' OR\r\n" + 
			" a.sym LIKE 'PAGINA WEB.%' OR\r\n" + 
			" a.sym LIKE 'DOMINIO.%' OR\r\n" + 
			" a.sym LIKE 'EMAIL MARKETING.%' OR\r\n" + 
			" a.sym LIKE 'REDES SOCIALES.%' OR\r\n" + 
			" a.sym LIKE 'SOPORTE A PC RECOVERY.%' OR\r\n" + 
			" a.sym LIKE 'SOPORTE TÉCNICO A PC Y DISPOSITIVOS.%' OR\r\n" + 
			" a.sym LIKE 'SOPORTE A ENDPOINT SECURITY.%' OR\r\n" + 
			" a.sym LIKE 'FICHA GOOGLE MAPS.%' OR\r\n" + 
			" a.sym LIKE 'E-COMMERCE.%' OR\r\n" + 
			" a.sym LIKE 'CRM.%' OR\r\n" + 
			" a.sym LIKE 'SOPORTE A FLOTILLAS.%') \r\n" + 
			"and a.sym LIKE :datoBusqueda \r\n" + 
			"group by a.sym",nativeQuery = true)
	
	public List<Object> getCategoriesIncidentesSingle(@Param("datoBusqueda") String datoBusqueda);
	
	@Query(value="SELECT a.id,a.persid, a.sym,a.tenant,a.ss_sym FROM db_ticketapisd.sdm_prob_ctg a\r\n" + 
			"where a.in_flag = 1 \r\n" + 
			"and a.del = 0\r\n" + 
			"and (a.sym = 'MON-GPON-TR.MDR.PUERTO OLT.POSIBLE CFO EN PUERTO PON' OR a.sym = 'SERVICIOS.FALLA MASIVA.SERVICIO DE DATOS') AND \r\n" +
			"(a.sym LIKE :datoBusqueda) \r\n" +
			"group by a.sym limit 25",nativeQuery = true)
	
	public List<Object> getCategoriesIncidentesMasivos(@Param("datoBusqueda") String datoBusqueda);
	
	@Query(value="SELECT a.id,a.persid, a.sym,a.tenant,a.ss_sym FROM db_ticketapisd.sdm_prob_ctg a\r\n" + 
			"where a.in_flag = 1 \r\n" + 
			"and a.del = 0\r\n" + 
			"and (a.sym = 'MON-GPON-TR.MDR.PUERTO OLT.POSIBLE CFO EN PUERTO PON' OR a.sym = 'SERVICIOS.FALLA MASIVA.SERVICIO DE DATOS') AND \r\n" +
			"(a.sym = :datoBusqueda) \r\n" +
			"group by a.sym limit 25",nativeQuery = true)
	
	public List<Object> getCategoriesIncidentesMasivosSingle(@Param("datoBusqueda") String datoBusqueda);
	
	@Query(value="SELECT  a.id,a.persid, a.sym,a.tenant,a.ss_sym FROM db_ticketapisd.sdm_prob_ctg a\r\n" + 
			"where a.cr_flag = 1 \r\n" + 
			"and a.del = 0\r\n" + 
			"and (a.sym LIKE 'Servicios de Red%') AND \r\n" +
			"(a.sym LIKE :datoBusqueda) \r\n" +
			"group by a.sym limit 25",nativeQuery = true)
	public List<Object> getCategoriesSolicitudes(@Param("datoBusqueda") String datoBusqueda);
	
	@Query(value="SELECT  a.id,a.persid, a.sym,a.tenant,a.ss_sym FROM db_ticketapisd.sdm_prob_ctg a\r\n" + 
			"where a.cr_flag = 1 \r\n" + 
			"and a.del = 0\r\n" + 
			"and (a.sym LIKE 'Servicios de Red%') AND \r\n" +
			"(a.sym = :datoBusqueda) \r\n" +
			"group by a.sym limit 25",nativeQuery = true)
	public List<Object> getCategoriesSolicitudesSingle(@Param("datoBusqueda") String datoBusqueda);
	
	public CatCategoriasModel findBySymAndInFlagAndDel(String nombre, Integer incidente, Integer inactive);
}
