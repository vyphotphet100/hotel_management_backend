package com.hotelmanagement.dto;

import java.util.Date;

public class CustomerDTO extends BaseDTO{

	private Long id;
	private String fullname;
	private String phone;
	private String identityCardNumber;
	private Date dayIn;
	private Date dayOut;
	private Date realDayOut;
	private String picture;
    private Long roomCheckInId;
    private Long roomCheckOutId;
    
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdentityCardNumber() {
		return identityCardNumber;
	}
	public void setIdentityCardNumber(String identityCardNumber) {
		this.identityCardNumber = identityCardNumber;
	}
	public Date getDayIn() {
		return dayIn;
	}
	public void setDayIn(Date dayIn) {
		this.dayIn = dayIn;
	}
	public Date getDayOut() {
		return dayOut;
	}
	public void setDayOut(Date dayOut) {
		this.dayOut = dayOut;
	}
	public Date getRealDayOut() {
		return realDayOut;
	}
	public void setRealDayOut(Date realDayOut) {
		this.realDayOut = realDayOut;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Long getRoomCheckInId() {
		return roomCheckInId;
	}
	public void setRoomCheckInId(Long roomCheckInId) {
		this.roomCheckInId = roomCheckInId;
	}
	public Long getRoomCheckOutId() {
		return roomCheckOutId;
	}
	public void setRoomCheckOutId(Long roomCheckOutId) {
		this.roomCheckOutId = roomCheckOutId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    
    
}
