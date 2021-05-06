package com.hotelmanagement.dto;

import java.util.ArrayList;
import java.util.List;

public class ShiftWeekdayRequirementDTO extends BaseDTO{
	
	private Integer weekday;
	private List<ShiftDTO> shifts = new ArrayList<ShiftDTO>();
	private List<ShiftRequirementDTO> shiftRequirements = new ArrayList<ShiftRequirementDTO>();
	public Integer getWeekday() {
		return weekday;
	}
	public void setWeekday(Integer weekday) {
		this.weekday = weekday;
	}
	public List<ShiftDTO> getShifts() {
		return shifts;
	}
	public void setShifts(List<ShiftDTO> shifts) {
		this.shifts = shifts;
	}
	public List<ShiftRequirementDTO> getShiftRequirements() {
		return shiftRequirements;
	}
	public void setShiftRequirements(List<ShiftRequirementDTO> shiftRequirements) {
		this.shiftRequirements = shiftRequirements;
	}
	
	
}
