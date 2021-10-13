package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OperationTicketNocRequest {

	@NotNull
	@Size(min = 1, max = 255)
	private String peackName;

	@NotNull
	@Size(min = 1, max = 255)
	private String categoryId;

	@NotNull
	@Size(min = 1, max = 255)
	private String[] description;

	@NotNull
	@Size(min = 1, max = 255)
	private String type;

	@NotNull
	@Size(min = 1, max = 255)
	private String requestBy;

	@NotNull
	@Size(min = 1, max = 255)
	private String diagInitial;

	private String regCiuId;

	private String url;

	private String group;

	public String getPeackName() {
		return peackName;
	}

	public void setPeackName(String peackName) {
		this.peackName = peackName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String[] getDescription() {
		return description;
	}

	public void setDescription(String[] description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}

	public String getDiagInitial() {
		return diagInitial;
	}

	public void setDiagInitial(String diagInitial) {
		this.diagInitial = diagInitial;
	}

	public String getRegCiuId() {
		return regCiuId;
	}

	public void setRegCiuId(String regCiuId) {
		this.regCiuId = regCiuId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}
