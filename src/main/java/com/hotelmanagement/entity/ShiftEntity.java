package com.hotelmanagement.entity;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "shift")
public class ShiftEntity extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "start_time")
	@Temporal(TIMESTAMP)
	private Date startTime;

	@Column(name = "end_time")
	@Temporal(TIMESTAMP)
	private Date endTime;
	
	@Column(name = "weekday")
	private Integer weekday;

	@ManyToMany(mappedBy = "shifts")
	private List<StaffEntity> staffs = new ArrayList<StaffEntity>();
	
	@OneToOne
    @JoinColumn(name = "shift_req_id", referencedColumnName = "id")
    private ShiftRequirementEntity shiftRequirement;

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

	public List<StaffEntity> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<StaffEntity> staffs) {
		this.staffs = staffs;
	}

	public Integer getWeekday() {
		return weekday;
	}

	public void setWeekday(Integer weekday) {
		this.weekday = weekday;
	}

	public ShiftRequirementEntity getShiftRequirement() {
		return shiftRequirement;
	}

	public void setShiftRequirement(ShiftRequirementEntity shiftRequirement) {
		this.shiftRequirement = shiftRequirement;
	}
	
}
