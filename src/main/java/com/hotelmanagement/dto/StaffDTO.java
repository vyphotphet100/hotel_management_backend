package com.hotelmanagement.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class StaffDTO extends BaseDTO implements UserDetails{

	private String username;
	private String password;
	private String fullname;
	private Date birthday;
	private String phone;
	private String address;
	private String picture;
	private String roleCode;
	private List<Long> shiftIds = new ArrayList<Long>();
    private String tokenCode;
    private List<String> checkInDates = new ArrayList<String>();
    private List<String> checkOutDates = new ArrayList<String>();
    
    private static final long serialVersionUID = 1L;
    private Collection<? extends GrantedAuthority> authorities = new ArrayList<>();
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getTokenCode() {
		return tokenCode;
	}
	public void setTokenCode(String tokenCode) {
		this.tokenCode = tokenCode;
	}
	public List<Long> getShiftIds() {
		return shiftIds;
	}
	public void setShiftIds(List<Long> shiftIds) {
		this.shiftIds = shiftIds;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	public List<String> getCheckInDates() {
		return checkInDates;
	}
	public void setCheckInDates(List<String> checkInDates) {
		this.checkInDates = checkInDates;
	}
	public List<String> getCheckOutDates() {
		return checkOutDates;
	}
	public void setCheckOutDates(List<String> checkOutDates) {
		this.checkOutDates = checkOutDates;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
    
}
