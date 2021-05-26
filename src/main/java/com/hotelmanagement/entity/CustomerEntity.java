package com.hotelmanagement.entity;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity{

	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "identity_card_number")
	private String identityCardNumber;
	
	@Column(name = "day_in")
	@Temporal(TIMESTAMP)
	private Date dayIn;
	
	@Column(name = "day_out")
	@Temporal(TIMESTAMP)
	private Date dayOut;
	
	@Column(name = "real_day_out")
	@Temporal(TIMESTAMP)
	private Date realDayOut;
	
	@Column(name = "picture")
	private String picture;
	
	@OneToOne(mappedBy = "customer")
    private RoomCheckInEntity roomCheckIn;
	
	@OneToOne(mappedBy = "customer")
    private RoomCheckOutEntity roomCheckOut;

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

	public RoomCheckInEntity getRoomCheckIn() {
		return roomCheckIn;
	}

	public void setRoomCheckIn(RoomCheckInEntity roomCheckIn) {
		this.roomCheckIn = roomCheckIn;
	}

	public RoomCheckOutEntity getRoomCheckOut() {
		return roomCheckOut;
	}

	public void setRoomCheckOut(RoomCheckOutEntity roomCheckOut) {
		this.roomCheckOut = roomCheckOut;
	}
	
	
}
