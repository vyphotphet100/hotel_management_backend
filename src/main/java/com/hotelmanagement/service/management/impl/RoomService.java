package com.hotelmanagement.service.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.dto.RoomDTO;
import com.hotelmanagement.entity.RoomEntity;
import com.hotelmanagement.repository.RoomRepository;
import com.hotelmanagement.service.management.IRoomService;

@Service
public class RoomService extends BaseService implements IRoomService{

	@Autowired
	private RoomRepository roomRepo;
	
	@Override
	public RoomDTO findAll() {
		RoomDTO roomDto = new RoomDTO();
		List<RoomEntity> roomEntities = roomRepo.findAll();
		
		if (!roomEntities.isEmpty()) {
			for (RoomEntity roomEntity : roomEntities)
				roomDto.getListResult().add(this.converter.toDTO(roomEntity, RoomDTO.class));
			
			roomDto.setMessage("Load room list successfully.");
			return roomDto;
		}
		
		return (RoomDTO)this.ExceptionObject(roomDto, "There is no any room.");
	}

	@Override
	public RoomDTO findOne(String id) {
		if (roomRepo.findOne(id) != null) {
			RoomDTO roomDto = this.converter.toDTO(roomRepo.findOne(id), RoomDTO.class);
			roomDto.setCreatedBy("Get room having id = " + id + " successfully.");
			return roomDto;
		}
		
		return (RoomDTO)this.ExceptionObject(new RoomDTO(), "This room id does not exist.");
	}

	@Override
	public RoomDTO save(RoomDTO roomDto) {
		if (roomRepo.findOne(roomDto.getId()) == null) {
			RoomEntity roomEntity = roomRepo.save(this.converter.toEntity(roomDto, RoomEntity.class));
			roomDto = this.converter.toDTO(roomEntity, RoomDTO.class);
			roomDto.setMessage("Save room successfully.");
			return roomDto;
		}
		
		return (RoomDTO)this.ExceptionObject(roomDto, "This room id exists already.");
	}

	@Override
	public RoomDTO update(RoomDTO roomDto) {
		if (roomRepo.findOne(roomDto.getId()) != null) {
			RoomEntity roomEntity = roomRepo.save(this.converter.toEntity(roomDto, RoomEntity.class));
			roomDto = this.converter.toDTO(roomEntity, RoomDTO.class);
			roomDto.setMessage("Update room successfully.");
			return roomDto;
		}
		
		return (RoomDTO)this.ExceptionObject(roomDto, "This room id does not exist.");
	}

	@Override
	public RoomDTO delete(String id) {
		if (roomRepo.findOne(id) != null) {
			roomRepo.delete(id);
			RoomDTO roomDto = new RoomDTO();
			roomDto.setCreatedBy("Delete room having id = " + id + " successfully.");
			return roomDto;
		}
		
		return (RoomDTO)this.ExceptionObject(new RoomDTO(), "This room id does not exist.");
	}

}
