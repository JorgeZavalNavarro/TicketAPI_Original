package com.enlacetpe.ticketapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enlacetpe.ticketapi.request.DeviceAndAlarm;
import com.enlacetpe.ticketapi.request.StatusRequestByRequest;
import com.enlacetpe.ticketapi.request.StatusOrganizationRequest;
import com.enlacetpe.ticketapi.request.TicketGroupRequest;
import com.enlacetpe.ticketapi.request.TicketIpRequest;
import com.enlacetpe.ticketapi.request.TicketOrganizationRequest;
import com.enlacetpe.ticketapi.request.TicketRefNumRequest;
import com.enlacetpe.ticketapi.response.CACommentList;
import com.enlacetpe.ticketapi.response.CAStatus;
import com.enlacetpe.ticketapi.response.CATicketByNameCIList;
import com.enlacetpe.ticketapi.response.CATicketList;
import com.enlacetpe.ticketapi.response.CATicketResponse;
import com.enlacetpe.ticketapi.service.CMDB.TicketManager;
import com.enlacetpe.ticketapi.service.serviceDesk.CommentTicketManager;
import com.enlacetpe.ticketapi.util.ActivityLogger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "ticket")
@RequestMapping(value = "/ticket")
public class TicketController {

	@Autowired
	private TicketManager ticketManager;

	@Autowired
	private CommentTicketManager commentTicketManager;

	@RequestMapping(value = "/refnum", method = RequestMethod.POST)
	@ApiOperation(value = "Recupera un ticket por numero de Referencia", notes = "Recupera un ticket por numero de Referencia")
	public ResponseEntity<CATicketList> getTicketByRefNum(@Valid @RequestBody TicketRefNumRequest request) {
		ActivityLogger.logMethod("getTicketByRefNum");
		CATicketList ticket = ticketManager.getTicket("refNum", request);
		return new ResponseEntity<CATicketList>(ticket, HttpStatus.OK);
	}

	@RequestMapping(value = "/activeCMDB", method = RequestMethod.POST)
	@ApiOperation(value = "Recupera los tickets activos por organizacion", notes = "Recupera los tickets activos por organizacion")
	public ResponseEntity<CATicketList> getTicketActiveCMDB(@Valid @RequestBody TicketOrganizationRequest request) {
		ActivityLogger.logMethod("getTicketActiveCMDB");
		CATicketList ticket = ticketManager.getTicket("ActiveCMDB", request);
		return new ResponseEntity<CATicketList>(ticket, HttpStatus.OK);
	}

	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	@ApiOperation(value = "Recupera los comentarios de un ticket", notes = "Recupera los comentarios de un ticket")
	public ResponseEntity<CACommentList> getCommentByTicket(@Valid @RequestBody TicketRefNumRequest request) {
		ActivityLogger.logMethod("getCommentByTicket");
		CACommentList comentarios = commentTicketManager.consultComment(request);
		return new ResponseEntity<CACommentList>(comentarios, HttpStatus.OK);
	}

	@RequestMapping(value = "/byDeviceAndAlarm", method = RequestMethod.POST)
	@ApiOperation(value = "Recupera los tickets segun la lista de ci recibidos", notes = "Recupera los tickets segun la lista de ci recibidos")
	public ResponseEntity<CATicketByNameCIList> getTicketsByName(@RequestBody List<DeviceAndAlarm> request) {
		ActivityLogger.logMethod("getTicketsByName");
		CATicketByNameCIList tickets = ticketManager.getTicketsByNameCi(request);
		return new ResponseEntity<CATicketByNameCIList>(tickets, HttpStatus.OK);
	}

	@RequestMapping(value = "/estatus", method = RequestMethod.POST)
	@ApiOperation(value = "Recupera el estatus de un ticket", notes = "Recupera el estatus de un ticket")
	public ResponseEntity<CAStatus> getStatusByTicket(@RequestBody TicketRefNumRequest request) {
		ActivityLogger.logMethod("getStatusByTicket");
		CAStatus tickets = ticketManager.getStatusByTicket(request);
		return new ResponseEntity<CAStatus>(tickets, HttpStatus.OK);
	}

	@RequestMapping(value = "/gruop", method = RequestMethod.POST)
	@ApiOperation(value = "Recupera los tickets activos por grupo", notes = "Recupera los tickets activos por grupo")
	public ResponseEntity<CATicketList> getTicketActiveGroup(@Valid @RequestBody TicketGroupRequest request) {
		ActivityLogger.logMethod("getTicketActiveGroup");
		CATicketList ticket = ticketManager.getTicketByGroup(request);
		return new ResponseEntity<CATicketList>(ticket, HttpStatus.OK);
	}

	@RequestMapping(value = "/status/requestBy", method = RequestMethod.POST)
	@ApiOperation(value = "Recupera los tickets por estatus y por usuario solicitado", notes = "Recupera los tickets por estatus y por usuario solicitado")
	public ResponseEntity<CATicketList> getTicketStatusRequestBy(@RequestBody StatusRequestByRequest request) {
		ActivityLogger.logMethod("getTicketStatusRequestBy");
		CATicketList ticket = ticketManager.getTicketsByStatusAndRequestBy(request);
		return new ResponseEntity<CATicketList>(ticket, HttpStatus.OK);
	}

	@RequestMapping(value = "/ticketsByIP", method = RequestMethod.POST)
	@ApiOperation(value = "Recupera los tickets activos por ip", notes = "Recupera los tickets activos por ip")
	public ResponseEntity<CATicketList> getTicketActiveIP(@Valid @RequestBody TicketIpRequest request) {
		ActivityLogger.logMethod("getTicketActiveIP");
		CATicketList ticket = ticketManager.getTicketByIp(request);
		return new ResponseEntity<CATicketList>(ticket, HttpStatus.OK);
	}

	@RequestMapping(value = "/ticketsByStatusAndOrganization", method = RequestMethod.POST)
	@ApiOperation(value = "Recupera los tickets por estatus y organizacion", notes = "Recupera los tickets por estatus y organizacion")
	public ResponseEntity<CATicketList> getTicketsByStatusAndOrganization(
			@RequestBody StatusOrganizationRequest request) {
		ActivityLogger.logMethod("getTicketsByStatusAndOrganization");
		CATicketList ticket = ticketManager.getTicketsByStatusAndOrganization(request);
		return new ResponseEntity<CATicketList>(ticket, HttpStatus.OK);
	}

}
