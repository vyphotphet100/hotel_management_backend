package com.hotelmanagement.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

public class BaseDTO{

	private Long id;
	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;
	
	private String message;
	private HttpStatus httpStatus = HttpStatus.OK;
	private List<Object> listResult = new ArrayList<Object>();
	private List<Object> listRequest = new ArrayList<Object>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public List<Object> getListRequest() {
		return listRequest;
	}
	public void setListRequest(List<Object> listRequest) {
		this.listRequest = listRequest;
	}
	public List<Object> getListResult() {
		return listResult;
	}
	public void setListResult(List<Object> listResult) {
		this.listResult = listResult;
	}
	
}
