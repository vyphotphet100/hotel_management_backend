
package com.hotelmanagement.entity;

import java.util.Date;
import static javax.persistence.TemporalType.TIMESTAMP;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "record")
public class RecordEntity extends BaseEntity {

	@Column(name = "date")
	@Temporal(TIMESTAMP)
	private Date date;

	@Column(name = "day_of_week")
	private Integer dayOfWeek;

	@Column(name = "staff_username")
	private String staffUsername;

	@Column(name = "staff_fullname")
	private String staffFullname;

	@Column(name = "total_working_hour")
	private Integer totalWorkingHour;

	@Column(name = "total_resting_time")
	private Integer totalRestingTime;

	@Column(name = "total_compensation_time")
	private Integer totalCompensationTime;

	@Column(name = "wage")
	private Long wage;

	@Column(name = "fine")
	private Long fine;

	@Column(name = "compensation_wage")
	private Long compensationWage;

	@Column(name = "total_wage")
	private Long totalWage;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getStaffUsername() {
		return staffUsername;
	}

	public void setStaffUsername(String staffUsername) {
		this.staffUsername = staffUsername;
	}

	public String getStaffFullname() {
		return staffFullname;
	}

	public void setStaffFullname(String staffFullname) {
		this.staffFullname = staffFullname;
	}

	public Integer getTotalWorkingHour() {
		return totalWorkingHour;
	}

	public void setTotalWorkingHour(Integer totalWorkingHour) {
		this.totalWorkingHour = totalWorkingHour;
	}

	public Integer getTotalRestingTime() {
		return totalRestingTime;
	}

	public void setTotalRestingTime(Integer totalRestingTime) {
		this.totalRestingTime = totalRestingTime;
	}

	public Integer getTotalCompensationTime() {
		return totalCompensationTime;
	}

	public void setTotalCompensationTime(Integer totalCompensationTime) {
		this.totalCompensationTime = totalCompensationTime;
	}

	public Long getWage() {
		return wage;
	}

	public void setWage(Long wage) {
		this.wage = wage;
	}

	public Long getFine() {
		return fine;
	}

	public void setFine(Long fine) {
		this.fine = fine;
	}

	public Long getCompensationWage() {
		return compensationWage;
	}

	public void setCompensationWage(Long compensationWage) {
		this.compensationWage = compensationWage;
	}

	public Long getTotalWage() {
		return totalWage;
	}

	public void setTotalWage(Long totalWage) {
		this.totalWage = totalWage;
	}

	
}
