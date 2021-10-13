package com.enlacetpe.ticketapi.dictionary;

import java.util.Arrays;
import java.util.List;

public class TicketDictionary {
	
	//Ticket Query
	public static final String categoryCreateQuery = "id = <arg>";
	public static final String customerCreateQuery = "userid = '<arg>'";
	public static final String userCreateQuery = "userid = '<arg>'"; //first_name = '<arg>'
	public static final String ciName = "name ='<arg>'";
	public static final String status = "sym = '<arg>'";
	public static final String group = "last_name = '<arg>'";
	public static final String numeroSerie = "serial_number = '<arg>'";
	public static final String activos = "affected_resource.id=U'<arg>' and active= 1 and status != 'RE' and type='I'";
	public static final String activosProblem = "affected_resource.id=U'<arg>' and active= 1 and status != 'RE' and type='P'";
	public static final String organization = "name='<arg>' and delete_flag = 0";
	public static final String refNumQuery = "ref_num = '<arg>'";
	public static final String refNumAndActiveQuery = "ref_num = '<arg>' and active= 1";
	public static final String tenant = "name = '<arg>'";
	public static final String ipNetwork = "alarm_id='<arg>'";
	
	
	//Type Querys
	public static final String incidentQuery = " AND type = 'I'";
	public static final String problemQuery = " AND type = 'P'";
	public static final String requestQuery = " AND type = 'R'";
		
	//Request Soap Combo	
	public static final String[] persistentParam = {"persistent_id"};
	public static final String[] symParam = {"sym"};
	public static final String[] persistentIdParam = {"persistent_id","id"};
	public static final String[] codeIdParam = {"code","id"};
	public static final String[] statusParam = {"status"};
	public static final String[] refNumParam = {"ref_num","type.sym","group","summary","description","status.sym","open_date", "priority.sym","category.sym","affected_resource.serial_number","customer.combo_name","customer.phone_number","customer.email_address"};
	public static final String[] ticketParam = {"persistent_id","type","status","zRegCiu_id"};
	
	public static final String[] ticketParamText = {"persistent_id","type","status","zRegCiu_id", "affected_resource.serial_number"};
	
	
	//Response Soap
	public static final String persistentId = "persistent_id";
	public static final String sym = "sym";
	public static final String folioCmas = "folio_cmas";
	public static final String id = "id";
	public static final String refNum = "ref_num";
	public static final String code = "code";
	public static final String statusTicket = "status";
	public static final String typeTicket = "type";
	public static final String summary = "summary";

	
	
	
	//String
	public static final String statusPreticket = "Pre-Ticket";
	//TicketStatus
	public static final List<String> statusUpdateStatus = Arrays.asList("En curso","Cancelado","Cerrado","Resuelto");
	
}
