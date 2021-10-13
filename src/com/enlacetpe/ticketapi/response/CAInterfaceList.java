package com.enlacetpe.ticketapi.response;

import java.util.List;

import org.joda.time.Period;

public class CAInterfaceList extends CAResponse{
	
	private List<CAInterfaces> Interfaces;
	
	public CAInterfaceList(boolean success, Period timeRes, String error,List<CAInterfaces> interfaces) {
		super(success, timeRes, error);
		Interfaces = interfaces;
	}
	
	public List<CAInterfaces> getInterfaces() {
		return Interfaces;
	}
}
