package com.hotelmanagement.dto;

import java.util.Date;

public class CheckOutDTO extends BaseDTO{

	private Long id;
	private Date date;
	private Long staffId;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
