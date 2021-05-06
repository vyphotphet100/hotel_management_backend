package com.hotelmanagement.entity;

import static javax.persistence.TemporalType.TIMESTAMP;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "check_out")
public class CheckOutEntity extends BaseEntity{

	@Column(name = "date")
	@Temporal(TIMESTAMP)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private StaffEntity staff;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public StaffEntity getStaff() {
		return staff;
	}

	public void setStaff(StaffEntity staff) {
		this.staff = staff;
	}
	
	
}
