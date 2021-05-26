package com.hotelmanagement.entity;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "room")
public class RoomEntity {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "status")
	private String status;
	
	@OneToMany(mappedBy = "room")
    private List<RoomCheckInEntity> roomCheckIns = new ArrayList<RoomCheckInEntity>();
	
	@OneToMany(mappedBy = "room")
    private List<RoomCheckOutEntity> roomCheckOuts = new ArrayList<RoomCheckOutEntity>();
	
	@Column(name = "createdby")
	@CreatedBy
	private String createdBy;

	@Column(name = "createddate")
	@CreatedDate
	@Temporal(TIMESTAMP)
	private Date createdDate;
	
	@Column(name = "modifiedby")
	@LastModifiedBy
	private String modifiedBy;
	
	@Column(name = "modifieddate")
	@LastModifiedDate
	@Temporal(TIMESTAMP)
	private Date modifiedDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public List<RoomCheckInEntity> getRoomCheckIns() {
		return roomCheckIns;
	}

	public void setRoomCheckIns(List<RoomCheckInEntity> roomCheckIns) {
		this.roomCheckIns = roomCheckIns;
	}

	public List<RoomCheckOutEntity> getRoomCheckOuts() {
		return roomCheckOuts;
	}

	public void setRoomCheckOuts(List<RoomCheckOutEntity> roomCheckOuts) {
		this.roomCheckOuts = roomCheckOuts;
	}
	
	
}
