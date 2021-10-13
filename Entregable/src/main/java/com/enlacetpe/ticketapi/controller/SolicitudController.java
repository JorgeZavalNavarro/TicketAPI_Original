package com.enlacetpe.ticketapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enlacetpe.ticketapi.response.CATicketList;
import com.enlacetpe.ticketapi.service.serviceDesk.SolicitudManager;
import com.enlacetpe.ticketapi.util.ActivityLogger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/solicitud")
@Api(value = "solicitud")
public class SolicitudController {

	@Autowired
	public SolicitudManager solicitudManager;

	@RequestMapping(value = "/addSolicitud", method = RequestMethod.POST)
	@ApiOperation(value = "Registra una solicitud", notes = "registra una solicitud")
	public ResponseEntity<CATicketList> registrarSolicitud() {
		ActivityLogger.logMethod("Registrar Solicitud");
		CATicketList solicitud = solicitudManager.registrarSolicitud();
		return new ResponseEntity<CATicketList>(solicitud, HttpStatus.OK);
	}
}
