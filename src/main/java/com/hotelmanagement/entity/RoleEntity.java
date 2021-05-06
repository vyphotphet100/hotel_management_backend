package com.hotelmanagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "wage_every_hour")
	private Long wageEveryHour;

	@OneToMany(mappedBy = "role")
	private List<StaffEntity> staffs = new ArrayList<StaffEntity>();

	@ManyToMany
	@JoinTable(name = "role_task", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
	private List<TaskEntity> tasks = new ArrayList<>();

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

	public List<StaffEntity> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<StaffEntity> staffs) {
		this.staffs = staffs;
	}

	public List<TaskEntity> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskEntity> tasks) {
		this.tasks = tasks;
	}

	
}
