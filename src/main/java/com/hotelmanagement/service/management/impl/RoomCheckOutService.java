package com.hotelmanagement.service.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.dto.RoomCheckOutDTO;
import com.hotelmanagement.entity.RoomCheckOutEntity;
import com.hotelmanagement.repository.RoomCheckOutRepository;
import com.hotelmanagement.service.management.IRoomCheckOutService;

@Service
public class RoomCheckOutService extends BaseService implements IRoomCheckOutService {

	@Autowired
	private RoomCheckOutRepository roomCheckOutRepo;

	@Override
	public RoomCheckOutDTO findAll() {
		RoomCheckOutDTO roomCheckOutDto = new RoomCheckOutDTO();
		List<RoomCheckOutEntity> roomCheckOutEntities = roomCheckOutRepo.findAll();

		if (!roomCheckOutEntities.isEmpty()) {
			for (RoomCheckOutEntity roomCheckOutEntity : roomCheckOutEntities)
				roomCheckOutDto.getListResult().add(this.converter.toDTO(roomCheckOutEntity, RoomCheckOutDTO.class));

			roomCheckOutDto.setMessage("Load room_check_out list successfully.");
			return roomCheckOutDto;
		}

		return (RoomCheckOutDTO) this.ExceptionObject(roomCheckOutDto, "There is no any room_check_out.");
	}

	@Override
	public RoomCheckOutDTO findOne(Long id) {
		RoomCheckOutEntity roomCheckOutEntity = roomCheckOutRepo.findOne(id);
		if (roomCheckOutEntity != null) {
			RoomCheckOutDTO roomCheckOutDto = this.converter.toDTO(roomCheckOutEntity, RoomCheckOutDTO.class);
			roomCheckOutDto.setMessage("Get room_check_out having id = " + id + " successfully.");
			return roomCheckOutDto;
		}

		return (RoomCheckOutDTO) this.ExceptionObject(new RoomCheckOutDTO(), "This room_check_out id does not exist.");
	}

	@Override
	public RoomCheckOutDTO save(RoomCheckOutDTO roomCheckOutDto) {
		RoomCheckOutEntity roomCheckOutEntity = this.converter.toEntity(roomCheckOutDto, RoomCheckOutEntity.class);
		roomCheckOutEntity = roomCheckOutRepo.save(roomCheckOutEntity);
		roomCheckOutDto = this.converter.toDTO(roomCheckOutEntity, RoomCheckOutDTO.class);
		roomCheckOutDto.setMessage("Save this room_check_out successfully.");
		return roomCheckOutDto;
	}

	@Override
	public RoomCheckOutDTO update(RoomCheckOutDTO roomCheckOutDto) {
		if (roomCheckOutRepo.findOne(roomCheckOutDto.getId()) != null) {
			RoomCheckOutEntity roomCheckOutEntity = this.converter.toEntity(roomCheckOutDto, RoomCheckOutEntity.class);
			roomCheckOutDto = this.converter.toDTO(roomCheckOutRepo.save(roomCheckOutEntity), RoomCheckOutDTO.class);
			roomCheckOutDto.setMessage("Update this room_check_out successfully.");
			return roomCheckOutDto;
		}
		
		return (RoomCheckOutDTO)this.ExceptionObject(roomCheckOutDto, "This room_check_out id does not exist.");
	}

	@Override
	public RoomCheckOutDTO delete(Long id) {
		if (roomCheckOutRepo.findOne(id) != null) {
			roomCheckOutRepo.delete(id);
			RoomCheckOutDTO roomCheckOutDto = new RoomCheckOutDTO();
			roomCheckOutDto.setMessage("Delete room_check_out successfully.");
			return roomCheckOutDto;
		}
		
		return (RoomCheckOutDTO)this.ExceptionObject(new RoomCheckOutDTO(), "This room_check_out id does not exist.");
	}

}
