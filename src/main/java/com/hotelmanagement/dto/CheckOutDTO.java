package com.hotelmanagement.dto;

import java.util.Date;

public class CheckOutDTO extends BaseDTO{

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
	
	
}
