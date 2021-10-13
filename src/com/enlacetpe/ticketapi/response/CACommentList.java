package com.enlacetpe.ticketapi.response;

import java.util.List;

import org.joda.time.Period;

public class CACommentList extends CAResponse{
	
	private List<CAComment> comentarios;

	public List<CAComment> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<CAComment> comentarios) {
		this.comentarios = comentarios;
	}
	
	public CACommentList(Boolean status, Period time, String error, String mssg, List<CAComment> comentarios) {
		super(status, time, error, mssg);
		this.comentarios = comentarios;
	}
	
	

}
