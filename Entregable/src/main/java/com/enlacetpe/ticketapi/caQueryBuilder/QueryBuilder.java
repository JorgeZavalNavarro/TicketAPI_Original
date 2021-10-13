package com.enlacetpe.ticketapi.caQueryBuilder;

import org.stringtemplate.v4.ST;


public class QueryBuilder {
	
	public static String buildQuery(String param, String type) {
		String query = null;
		if (type.equals("organization"))
			query = "name='<arg>' and delete_flag = 0";
		else if(type.equals("class"))
			query = "type='<arg>'";
		else if(type.equals("olt"))
			query = "alarm_id='<arg>'";
		else if(type.equals("ont"))
			query = "name='<arg>'";
		else if(type.equals("relacion"))
			query = "parenttochild='<arg>'";
		else if(type.equals("numeroSerie"))
			query = "serial_number='<arg>'";
		else if(type.equals("ipNetwork"))
			query = "alarm_id='<arg>'";
		ST built = new ST(query);
		built.add("arg", param);		
		return built.render();
	}
}
