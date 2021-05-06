package com.hotelmanagement.entity;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "work_time")
public class WorkTimeEntity extends BaseEntity{

	@Column(name = "date")
	@Temporal(TIMESTAMP)
	private Date date;
	
	@Column(name = "staff_id")
	private Long staffId;
	
	@Column(name = "start_time")
	@Temporal(TIMESTAMP)
	private Date startTime;
	
	@Column(name = "end_time")
	@Temporal(TIMESTAMP)
	private Date endTime;

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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
