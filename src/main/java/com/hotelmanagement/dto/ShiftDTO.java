package com.hotelmanagement.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShiftDTO extends BaseDTO{

	private String code;
	private String name;
	private Date startTime;
	private Date endTime;
	private List<String> staffUsernames = new ArrayList<String>();
	private List<ShiftWeekdayRequirementDTO> shiftWeekdayRequirements = new ArrayList<ShiftWeekdayRequirementDTO>();
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public List<String> getStaffUsernames() {
		return staffUsernames;
	}
	public void setStaffUsernames(List<String> staffUsernames) {
		this.staffUsernames = staffUsernames;
	}
	public List<ShiftWeekdayRequirementDTO> getShiftWeekdayRequirements() {
		return shiftWeekdayRequirements;
	}
	public void setShiftWeekdayRequirements(List<ShiftWeekdayRequirementDTO> shiftWeekdayRequirements) {
		this.shiftWeekdayRequirements = shiftWeekdayRequirements;
	}
	
	
}
