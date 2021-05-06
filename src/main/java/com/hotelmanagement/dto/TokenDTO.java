package com.hotelmanagement.dto;

public class TokenDTO extends BaseDTO{
	private String code;
    private String staffUsername;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStaffUsername() {
		return staffUsername;
	}
	public void setStaffUsername(String staffUsername) {
		this.staffUsername = staffUsername;
	}
	
}
