package com.hotelmanagement.dto;

import java.util.ArrayList;
import java.util.List;

public class ShiftRequirementDTO extends BaseDTO{
	
	private Integer numOfAdmin;
	private Integer numOfReception;
	private Integer numOfLabor;
	private List<ShiftWeekdayRequirementDTO> shiftWeekdayRequirements = new ArrayList<ShiftWeekdayRequirementDTO>();
	public Integer getNumOfAdmin() {
		return numOfAdmin;
	}
	public void setNumOfAdmin(Integer numOfAdmin) {
		this.numOfAdmin = numOfAdmin;
	}
	public Integer getNumOfReception() {
		return numOfReception;
	}
	public void setNumOfReception(Integer numOfReception) {
		this.numOfReception = numOfReception;
	}
	public Integer getNumOfLabor() {
		return numOfLabor;
	}
	public void setNumOfLabor(Integer numOfLabor) {
		this.numOfLabor = numOfLabor;
	}
	public List<ShiftWeekdayRequirementDTO> getShiftWeekdayRequirements() {
		return shiftWeekdayRequirements;
	}
	public void setShiftWeekdayRequirements(List<ShiftWeekdayRequirementDTO> shiftWeekdayRequirements) {
		this.shiftWeekdayRequirements = shiftWeekdayRequirements;
	}
	
	
}
