package com.hotelmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shift_requirement")
public class ShiftRequirementEntity extends BaseEntity {

	@Column(name = "num_of_admin")
	private Integer numOfAdmin;

	@Column(name = "num_of_reception")
	private Integer numOfReception;

	@Column(name = "num_of_labor")
	private Integer numOfLabor;
	
	@OneToOne(mappedBy = "shiftRequirement")
    private ShiftEntity shift;

	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "shiftReq_shiftWeekdayReq", joinColumns = @JoinColumn(name
	 * = "shift_req_id"), inverseJoinColumns = @JoinColumn(name =
	 * "shift_week_req_id")) private List<ShiftWeekdayRequirementEntity>
	 * shiftWeekdayRequirements = new ArrayList<ShiftWeekdayRequirementEntity>();
	 */

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

	public ShiftEntity getShift() {
		return shift;
	}

	public void setShift(ShiftEntity shift) {
		this.shift = shift;
	}

}
