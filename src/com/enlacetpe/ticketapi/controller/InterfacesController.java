package com.enlacetpe.ticketapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enlacetpe.ticketapi.request.Interfaces;
import com.enlacetpe.ticketapi.response.CAInterfaceList;
import com.enlacetpe.ticketapi.service.CMDB.InterfaceManager;
import com.enlacetpe.ticketapi.util.ActivityLogger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="interfaces")
@RequestMapping(value = "/interfaces")
public class InterfacesController {
	
//	@Autowired
//	private InterfaceManager interfaceManager;
//	
//	@RequestMapping(value = "/byPeack", method = RequestMethod.POST)
//	@ApiOperation(value = "Recupera las interfaces por ip", notes = "Recupera las interfaces por ip")
//	public ResponseEntity<CAInterfaceList> getInterfaces(@RequestBody Interfaces request) {
//		ActivityLogger.logMethod("getInterfaces");
//		CAInterfaceList response  = interfaceManager.getInterface(request);
//		return new ResponseEntity<CAInterfaceList>(response, HttpStatus.OK);		
//	}
}
