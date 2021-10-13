package com.enlacetpe.ticketapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enlacetpe.ticketapi.request.Id;
import com.enlacetpe.ticketapi.request.Name;
import com.enlacetpe.ticketapi.response.CAOrganizationCatalogo;
import com.enlacetpe.ticketapi.response.CAStatus;
import com.enlacetpe.ticketapi.response.CACatalogo;
import com.enlacetpe.ticketapi.service.serviceDesk.CatalogoManager;
import com.enlacetpe.ticketapi.util.ActivityLogger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value="catalogo")
@RequestMapping(value = "/catalogo")
public class CatalogoController {
	
	@Autowired
	private CatalogoManager catalogoStatusManager;
	
	
	@RequestMapping(value = "/status", method = RequestMethod.POST)
	@ApiOperation(value = "Catalogo de status", notes = "Catalogo de status")
	public ResponseEntity<List<CAStatus>> getCatalogoStatus() {
		ActivityLogger.logMethod("getCatalogoStatus");
		List<CAStatus> catalogo = catalogoStatusManager.catStatus();
		return new ResponseEntity<List<CAStatus>>(catalogo, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/regionesCiudades", method = RequestMethod.POST)
	@ApiOperation(value = "Catalogo Ciudad Region para generar ticket", notes = "Catalogo Ciudad Region para generar ticket")
	public ResponseEntity<List<CACatalogo>> getCatalogoRegionesCiudades() {
		ActivityLogger.logMethod("getCatalogoRegionesCiudades");
		List<CACatalogo> catalogo = catalogoStatusManager.catRegCiudad();
		return new ResponseEntity<List<CACatalogo>>(catalogo, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/diagnostico", method = RequestMethod.POST)
	@ApiOperation(value = "Catalogo Ciudad Region para generar ticket", notes = "Catalogo Ciudad Region para generar ticket")
	public ResponseEntity<List<CACatalogo>> getCatalogoDiagnostico() {
		ActivityLogger.logMethod("getCatalogoDiagnostico");
		List<CACatalogo> catalogo = catalogoStatusManager.catDiagnostico();
		return new ResponseEntity<List<CACatalogo>>(catalogo, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/solucion", method = RequestMethod.POST)
	@ApiOperation(value = "Catalogo Ciudad Region para generar ticket", notes = "Catalogo Ciudad Region para generar ticket")
	public ResponseEntity<List<CACatalogo>> getCatalogoSolucion(@RequestBody Id request) {
		ActivityLogger.logMethod("getCatalogoSolucion");
		List<CACatalogo> catalogo = catalogoStatusManager.caSolucion(request.getId());
		return new ResponseEntity<List<CACatalogo>>(catalogo, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/organization", method = RequestMethod.POST)
	@ApiOperation(value = "Catalogo organizacion", notes = "Catalogo organizacion")
	public ResponseEntity<List<CAOrganizationCatalogo>> getCatalogoOrganization() {
		ActivityLogger.logMethod("getCatalogoOrganization");
		List<CAOrganizationCatalogo> catalogo = catalogoStatusManager.caOrganizaciones();
		return new ResponseEntity<List<CAOrganizationCatalogo>>(catalogo, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/group", method = RequestMethod.POST)
	@ApiOperation(value = "Catalogo grupos ", notes = "Catalogo grupos")
	public ResponseEntity<List<CACatalogo>> getCatalogoGroup(@RequestBody Name request) {
		ActivityLogger.logMethod("getCatalogoGroup");
		List<CACatalogo> catalogo = catalogoStatusManager.caGroup(request.getName());
		return new ResponseEntity<List<CACatalogo>>(catalogo, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/group/all", method = RequestMethod.POST)
	@ApiOperation(value = "Catalogo grupos ", notes = "Catalogo grupos")
	public ResponseEntity<List<CACatalogo>> getCatalogoGroupAll() {
		ActivityLogger.logMethod("getCatalogoGroupAll");
		List<CACatalogo> catalogo = catalogoStatusManager.caGroupAll();
		return new ResponseEntity<List<CACatalogo>>(catalogo, HttpStatus.OK);		
	}
	
}
