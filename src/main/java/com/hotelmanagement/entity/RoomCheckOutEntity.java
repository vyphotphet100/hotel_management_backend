package com.hotelmanagement.entity;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "room_check_out")
public class RoomCheckOutEntity extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "room_id")
	private RoomEntity room;

	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private CustomerEntity customer;

	@Column(name = "date")
	@Temporal(TIMESTAMP)
	private Date date;
	
	@ManyToMany
	@JoinTable(name = "room_check_out_staff", joinColumns = @JoinColumn(name = "room_check_out_id"), inverseJoinColumns = @JoinColumn(name = "staff_id"))
	private List<StaffEntity> staffs = new ArrayList<StaffEntity>();

	public RoomEntity getRoom() {
		return room;
	}

	public void setRoom(RoomEntity room) {
		this.room = room;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<StaffEntity> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<StaffEntity> staffs) {
		this.staffs = staffs;
	}

	
}
