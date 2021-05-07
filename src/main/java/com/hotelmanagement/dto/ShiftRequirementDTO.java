package com.hotelmanagement.dto;

public class ShiftRequirementDTO extends BaseDTO{
	
	private Integer numOfAdmin;
	private Integer numOfReception;
	private Integer numOfLabor;
	private Long shiftId;
	
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
	public Long getShiftId() {
		return shiftId;
	}
	public void setShiftId(Long shiftId) {
		this.shiftId = shiftId;
	}
	
}
