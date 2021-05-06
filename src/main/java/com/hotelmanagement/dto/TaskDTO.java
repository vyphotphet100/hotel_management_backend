package com.hotelmanagement.dto;

import java.util.ArrayList;
import java.util.List;

public class TaskDTO extends BaseDTO{
	private String code;
	private String name;
	private String description;
	private List<RoleDTO> roles = new ArrayList<RoleDTO>();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<RoleDTO> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}
	
	
}
