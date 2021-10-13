package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CommentRequest {

	@NotNull
	@Size(min=1, max=10)
	private String refNum;
	
	@NotNull
	@Size(min=1, max=500)
	private String comment;
	
	@NotNull
	@Size(min=1, max=500)
	private String creatorUUID;
	
	public String getRefNum() {
		return refNum;
	}
	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCreatorUUID() {
		return creatorUUID;
	}
	public void setCreatorUUID(String creatorUUID) {
		this.creatorUUID = creatorUUID;
	}
	
	
}
