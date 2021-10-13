package com.enlacetpe.ticketapi.service.serviceDesk;

import java.rmi.RemoteException;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlacetpe.ticketapi.caManager.serviceDesk.CALogInValidator;
import com.enlacetpe.ticketapi.caManager.serviceDesk.CAObjectValidator;
import com.enlacetpe.ticketapi.caManager.serviceDesk.CAQueryValidator;
import com.enlacetpe.ticketapi.caMapper.serviceDesk.CATicketMapper;
import com.enlacetpe.ticketapi.caQueryBuilder.TicketQueryBuilder;
import com.enlacetpe.ticketapi.dictionary.TicketDictionary;
import com.enlacetpe.ticketapi.request.ExternalSystemTicketRequest;
import com.enlacetpe.ticketapi.response.CAResponse;

@Service
public class ChangeTicketManager {
	
final static Logger logger = Logger.getLogger(ChangeTicketManager.class);
	
	@Autowired
	private CALogInValidator logInValidator;
	
	@Autowired
	private CAQueryValidator queryValidator;
	
	@Autowired
	private CAObjectValidator objValidator;

	
	@SuppressWarnings("unused")
	public CAResponse updateTicket(ExternalSystemTicketRequest request ) {
		DateTime initial = new DateTime();
		Boolean success = true;
		Integer token = null;
		String error = null;
		String mssg = "";
		try {	
			CATicketMapper mapper = new CATicketMapper();
			token = logInValidator.getToken();
			String userHandle = logInValidator.getUserHandle(token);
			String requestByTicket = TicketQueryBuilder.buildQuery(request.getRefNum(), "refNum"); //Busco por ref num y que el ticket este activo
			String requestByXmlTicket = queryValidator.doSelect(token, "cr", requestByTicket, 1,TicketDictionary.ticketParam);
			String ticket = mapper.getValueByAttrName(requestByXmlTicket, TicketDictionary.persistentId);
			String ticketStatus = mapper.getValueByAttrName(requestByXmlTicket, TicketDictionary.statusTicket);
			String tipoTicket = mapper.getValueByAttrName(requestByXmlTicket, TicketDictionary.statusTicket);
			
			
			
			if(!ticket.isEmpty() && ticket != null) {
				if(!ticketStatus.equalsIgnoreCase("CL")) {
					String[] attributes = new String[] {};
					String[] attrVals = new String[] { 
							"external_system_ticket",request.getExternaSystemTicket(),
					};
					String response = objValidator.updateObject(token,ticket, attrVals, attributes);
					mssg ="Ticket Actualizado..";
				}else {
					success = false;
					error = "No se puede actualizar un ticket inactivo";
					logger.error("No se puede actualizar un ticket inactivo" +request.getRefNum() + ":"+ error);
				}
			}else {
				success = false;
				error = "No se enontro el ticket: " + request.getRefNum() ;
				logger.error("No se enontro el ticket: " +request.getRefNum() + ":"+ error);
			}
		
			logInValidator.closeToken(token);
		} catch(Exception e) {
			success = false;
			error = "Error al actualizar el ticket " + request.getRefNum() +" :"+ e.toString();
			logger.error("Error al actualizar el ticket " +request.getRefNum() + ":"+ error);
		} finally {
			try {
				if(token != null)
					logInValidator.closeToken(token);
			} catch (RemoteException e) {
				logger.error(e.toString());
				error = "Error al actualizar el ticket: "+ e.toString();
			}
		}
		Period period = new Period(initial, new DateTime());
		return new CAResponse(success, period, error,mssg);
	}
	

}
