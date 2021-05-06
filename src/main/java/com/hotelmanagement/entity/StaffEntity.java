package com.hotelmanagement.entity;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "staff")
public class StaffEntity extends BaseEntity {

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "fullname")
	private String fullname;

	@Column(name = "birthday")
	@Temporal(TIMESTAMP)
	private Date birthday;

	@Column(name = "phone")
	private String phone;

	@Column(name = "address", columnDefinition = "TEXT")
	private String address;

	@Column(name = "picture", columnDefinition = "TEXT")
	private String picture;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleEntity role;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "staff_shift", joinColumns = @JoinColumn(name = "staff_id"), inverseJoinColumns = @JoinColumn(name = "shift_id"))
	private List<ShiftEntity> shifts = new ArrayList<ShiftEntity>();
	
	@OneToOne
    @JoinColumn(name = "token_id", referencedColumnName = "id")
    private TokenEntity token;
	
	@OneToMany(mappedBy = "staff")
	private List<CheckInEntity> checkIns = new ArrayList<CheckInEntity>();
	
	@OneToMany(mappedBy = "staff")
	private List<CheckOutEntity> checkOuts = new ArrayList<CheckOutEntity>();

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

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public List<ShiftEntity> getShifts() {
		return shifts;
	}

	public void setShifts(List<ShiftEntity> shifts) {
		this.shifts = shifts;
	}

	public TokenEntity getToken() {
		return token;
	}

	public void setToken(TokenEntity token) {
		this.token = token;
	}

	public List<CheckInEntity> getCheckIns() {
		return checkIns;
	}

	public void setCheckIns(List<CheckInEntity> checkIns) {
		this.checkIns = checkIns;
	}

	public List<CheckOutEntity> getCheckOuts() {
		return checkOuts;
	}

	public void setCheckOuts(List<CheckOutEntity> checkOuts) {
		this.checkOuts = checkOuts;
	}

}
