package com.enlacetpe.ticketapi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enlacetpe.ticketapi.request.ActualizarPuntaRequest;
import com.enlacetpe.ticketapi.request.ConsultarCiudadesRequest;
import com.enlacetpe.ticketapi.request.PuntaRequest;
import com.enlacetpe.ticketapi.request.ipRequest;
import com.enlacetpe.ticketapi.response.ActualizarPuntaResponse;
import com.enlacetpe.ticketapi.response.CAInformacionIp;
import com.enlacetpe.ticketapi.response.CAInformacionPunta;
import com.enlacetpe.ticketapi.response.CAResponse;
import com.enlacetpe.ticketapi.response.TCiudadesList;
import com.enlacetpe.ticketapi.service.CMDB.PuntaManager;
import com.enlacetpe.ticketapi.util.ActivityLogger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "punta")
@RequestMapping(value = "/punta")
public class PuntaController {
	
	

	@Autowired
	private PuntaManager puntaManager;

	@RequestMapping(value = "/ticketActivos", method = RequestMethod.POST) // lo
																			// ocupa
																			// grafana
	@ApiOperation(value = "Regresa booleno si la punta tiene tickets activos", notes = "Regresa booleno si la punta tiene tickets activos")
	public ResponseEntity<CAResponse> existTicketActivos(@RequestBody PuntaRequest request) {
		ActivityLogger.logMethod("existTicketActivos");
		CAResponse response = puntaManager.tieneTicketActivos(request);
		return new ResponseEntity<CAResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/information", method = RequestMethod.POST) // lo
																			// ocupa
																			// tableros
																			// de
																			// dcp
	@ApiOperation(value = "Regresa la informacion de algun server", notes = "Regresa la informacion de algun server")
	public ResponseEntity<CAInformacionPunta> informationPunta(@RequestBody @Valid ipRequest request,
			BindingResult result, HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("informationPunta");

		CAInformacionPunta response = new CAInformacionPunta();
		if (result.hasErrors()) {
			DateTime initial = new DateTime();
			System.out.println("Hay problemas");
			httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			List<ObjectError> errors = result.getAllErrors();
			Period period = new Period(initial, new DateTime());
			for (ObjectError oe : errors) {
				response = new CAInformacionPunta(false, period, oe.getDefaultMessage(), "", "", "", "", 0);
			}
		} else {
			response = puntaManager.getInformation(request);
		}

		return new ResponseEntity<CAInformacionPunta>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/informationIP", method = RequestMethod.POST) 
	@ApiOperation(value = "Regresa la informacion de algun server", notes = "Regresa la informacion de algun server")
	public ResponseEntity<CAInformacionIp> informationIP(@RequestBody @Valid ipRequest request, BindingResult result,
			HttpServletResponse httpResponse) {
		ActivityLogger.logMethod("informationIP");

		CAInformacionIp response = new CAInformacionIp();
		if (result.hasErrors()) {
			DateTime initial = new DateTime();
			System.out.println("Hay problemas");
			httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			List<ObjectError> errors = result.getAllErrors();
			Period period = new Period(initial, new DateTime());
			for (ObjectError oe : errors) {
				response = new CAInformacionIp(false, period, oe.getDefaultMessage(), "", "");

			}
		} else {
			response = puntaManager.getInformationIP(request);
		}

		return new ResponseEntity<CAInformacionIp>(response, HttpStatus.OK);
	}
	
	
}
