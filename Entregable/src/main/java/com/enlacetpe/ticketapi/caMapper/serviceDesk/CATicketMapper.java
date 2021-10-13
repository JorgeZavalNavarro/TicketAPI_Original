package com.enlacetpe.ticketapi.caMapper.serviceDesk;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;

import com.enlacetpe.ticketapi.dictionary.TicketDictionary;
import com.enlacetpe.ticketapi.response.CATicket;

public class CATicketMapper extends CAMapper {

	private ArrayList<CATicket> list;

	public ArrayList<CATicket> map(String xml) throws Exception {
		list = new ArrayList<CATicket>();
		List<Element> rootList = getRootList(xml);
		for (Element root : rootList) {
			List<Element> attrs = root.getChild("Attributes").getChildren("Attribute");
			list.add(mapProp(attrs));
		}
		return list;
	}

	public ArrayList<CATicket> mapUnique(String xml) throws Exception {
		list = new ArrayList<CATicket>();
		Element root = getUniqueRootList(xml);
		List<Element> attrs = root.getChild("Attributes").getChildren("Attribute");
		list.add(mapProp(attrs));
		return list;
	}
	

	private CATicket mapProp(List<Element> elements) {
		CATicket ticket = new CATicket();

		for (Element element : elements) {
			String prop = element.getChildText("AttrName");
			String val = element.getChildText("AttrValue");
			
			if(prop != null && !val.equals("")) {
				if (prop.equals(TicketDictionary.refNum))
					ticket.setRefNum(val);
			 	if (prop.equals(TicketDictionary.id))
			 		ticket.setId(val);
			}	
		}
		return ticket;
	}
	
	
	public ArrayList<CATicket> mapUniqueTableros(String xml) throws Exception {
		list = new ArrayList<CATicket>();
		Element root = getUniqueRootList(xml);
		List<Element> attrs = root.getChild("Attributes").getChildren("Attribute");
		list.add(mapPropTableros(attrs));
		return list;
	}
	

	private CATicket mapPropTableros(List<Element> elements) {
		CATicket ticket = new CATicket();

		for (Element element : elements) {
			String prop = element.getChildText("AttrName");
			String val = element.getChildText("AttrValue");
			
			if(prop != null && !val.equals("")) {
				if (prop.equals(TicketDictionary.refNum))
					ticket.setRefNum(val);
			}	
		}
		return ticket;
	}
	
	
	public String maperComment(String xml) {
		String valor = null;
		try{
			Element root = getUniqueRootList(xml);
			valor = root.getChildText("Handle");
		}catch(Exception ex) {
			System.out.println("AddComent: Ocurrio un error cuando se mapeo " + ex);
		}
		return valor;
		
	}

	

	
}
