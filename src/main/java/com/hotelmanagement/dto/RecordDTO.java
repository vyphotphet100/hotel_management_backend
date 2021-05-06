package com.hotelmanagement.dto;

import java.util.Date;

public class RecordDTO extends BaseDTO{

	private Date date;
	private Integer datOfWeek;
	private String staffUsername;
	private String staffFullname;
	private Integer totalWorkingHour;
	private Integer totalRestingTime;
	private Integer totalCompensationTime;
	private Long wage;
	private Long fine;
	private Long compensationWage;
	private Long totalWage;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getDatOfWeek() {
		return datOfWeek;
	}
	public void setDatOfWeek(Integer datOfWeek) {
		this.datOfWeek = datOfWeek;
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
