package com.hotelmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "token")
public class TokenEntity extends BaseEntity{

	@Column(name = "code", columnDefinition = "TEXT")
	private String code;
	
	@OneToOne(mappedBy = "token")
    private StaffEntity staff;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public StaffEntity getStaff() {
		return staff;
	}

	public void setStaff(StaffEntity staff) {
		this.staff = staff;
	}
	
	
}
