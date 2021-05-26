package com.hotelmanagement.dto;

import java.util.ArrayList;
import java.util.List;

public class RoomDTO extends BaseDTO{
	
	private String id;
	private String type;
	private String status;
    private List<Long> roomCheckInIds = new ArrayList<Long>();
    private List<Long> roomCheckOutIds = new ArrayList<Long>();
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Long> getRoomCheckInIds() {
		return roomCheckInIds;
	}
	public void setRoomCheckInIds(List<Long> roomCheckInIds) {
		this.roomCheckInIds = roomCheckInIds;
	}
	public List<Long> getRoomCheckOutIds() {
		return roomCheckOutIds;
	}
	public void setRoomCheckOutIds(List<Long> roomCheckOutIds) {
		this.roomCheckOutIds = roomCheckOutIds;
	}

}
