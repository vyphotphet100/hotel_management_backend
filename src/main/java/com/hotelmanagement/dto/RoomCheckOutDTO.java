package com.hotelmanagement.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomCheckOutDTO extends BaseDTO{

	private Long id;
	private String roomId;
    private Long customerId;
	private Date date;
	private List<Long> staffIds = new ArrayList<Long>();
	
	
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Long> getStaffIds() {
		return staffIds;
	}
	public void setStaffIds(List<Long> staffIds) {
		this.staffIds = staffIds;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
