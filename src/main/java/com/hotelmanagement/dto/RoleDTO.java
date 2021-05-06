package com.hotelmanagement.dto;

import java.util.ArrayList;
import java.util.List;

public class RoleDTO extends BaseDTO{

	private String code;
	private String name;
	private Long wageEveryHour;
	private List<String> staffUsernames = new ArrayList<String>();
	private List<String> taskCodes = new ArrayList<String>();
	
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
	public Long getWageEveryHour() {
		return wageEveryHour;
	}
	public void setWageEveryHour(Long wageEveryHour) {
		this.wageEveryHour = wageEveryHour;
	}
	public List<String> getStaffUsernames() {
		return staffUsernames;
	}
	public void setStaffUsernames(List<String> staffUsernames) {
		this.staffUsernames = staffUsernames;
	}
	public List<String> getTaskCodes() {
		return taskCodes;
	}
	public void setTaskCodes(List<String> taskCodes) {
		this.taskCodes = taskCodes;
	}
	
	
}
