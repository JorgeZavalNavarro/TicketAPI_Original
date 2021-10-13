package com.enlacetpe.ticketapi.caQueryBuilder;

import org.stringtemplate.v4.ST;

import com.enlacetpe.ticketapi.dictionary.TicketDictionary;

public class TicketQueryBuilder {
	
	public static String buildQuery(String param, String type) {
		String query = null;
		if (type.equals("categoryCreate"))
			query = TicketDictionary.categoryCreateQuery;
		else if(type.equals("customerCreate")) 
			query = TicketDictionary.customerCreateQuery;
		else if(type.equals("userCreate"))
			query = TicketDictionary.userCreateQuery;
		else if(type.equals("CIName")) 
			query = TicketDictionary.ciName;
		else if(type.equals("CodeStatus"))
			query = TicketDictionary.status;
		else if(type.equals("group"))
			query = TicketDictionary.group;
		else if(type.equals("numeroSerie"))
			query = TicketDictionary.numeroSerie;
		else if(type.equals("ticketsActivos"))
			query = TicketDictionary.activos;
		else if(type.equals("organization"))
			query = TicketDictionary.organization;
		else if(type.equals("refNum"))
			query = TicketDictionary.refNumQuery;
		else if(type.equals("ticketsProblemas"))
			query = TicketDictionary.activosProblem;
		else if(type.equals("refNumAndActive"))
			query = TicketDictionary.refNumAndActiveQuery;
		else if(type.equals("tenant"))
			query = TicketDictionary.tenant;
		else if(type.equals("ipNetwork"))
			query = TicketDictionary.ipNetwork;
		
		
		
		
		ST built = new ST(query);
		built.add("arg", param);		
		return built.render();
	}
	
	public static String buildAditional(String type) {
		String aditional = null;
		if(type.equals("I")) {
			aditional = TicketDictionary.incidentQuery;
		} else if(type.equals("P")) {
			aditional = TicketDictionary.problemQuery;
		} else if(type.equals("R")) {
			aditional = TicketDictionary.requestQuery;
		}
		return aditional;
	}
	
	public static String validateTicketType(String type) {
		String validType = null;
		if(type.equals("I") || type.equals("P") || type.equals("R")) {
			validType = type;
		}
		return validType;
	}
}
