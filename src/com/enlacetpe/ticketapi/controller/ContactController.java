package com.enlacetpe.ticketapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enlacetpe.ticketapi.request.ContactOrganizationRequest;
import com.enlacetpe.ticketapi.response.CAContactList;
import com.enlacetpe.ticketapi.service.CMDB.ContactManager;
import com.enlacetpe.ticketapi.service.serviceDesk.ContactManagerSD;
import com.enlacetpe.ticketapi.util.ActivityLogger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="contact")
@RequestMapping(value = "/contact")
public class ContactController {
	
	@Autowired
	private ContactManager contactManager;
	
	@Autowired
	private ContactManagerSD contactManagerSD;
	
	@RequestMapping(value = "/organization", method = RequestMethod.POST)
	@ApiOperation(value = "Recupera un contacto por su organización", notes = "Recupera un contacto por su organización")
	public ResponseEntity<CAContactList> getContactByOrganization(
			@Valid @RequestBody ContactOrganizationRequest request) {
		ActivityLogger.logMethod("getContactByOrganization");
		CAContactList contact = contactManagerSD.getContact("organization", request.getOrganization());
		return new ResponseEntity<CAContactList>(contact, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/organizationCMDB", method = RequestMethod.POST)
	@ApiOperation(value = "Recupera un contacto por su organización de la CMDB", notes = "Recupera un contacto por su organización")
	public ResponseEntity<CAContactList> getContactByOrganizationCMDB(
			@Valid @RequestBody ContactOrganizationRequest request) {
		ActivityLogger.logMethod("getContactByOrganization");
		CAContactList contact = contactManager.getContactCMDB("organization", request.getOrganization());
		return new ResponseEntity<CAContactList>(contact, HttpStatus.OK);
	}
	
	
	

}
