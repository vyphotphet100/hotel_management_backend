package com.hotelmanagement.service.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.dto.RoomCheckInDTO;
import com.hotelmanagement.entity.RoomCheckInEntity;
import com.hotelmanagement.repository.RoomCheckInRepository;
import com.hotelmanagement.service.management.IRoomCheckInService;

@Service
public class RoomCheckInService extends BaseService implements IRoomCheckInService {

	@Autowired
	private RoomCheckInRepository roomCheckInRepo;

	@Override
	public RoomCheckInDTO findAll() {
		RoomCheckInDTO roomCheckInDto = new RoomCheckInDTO();
		List<RoomCheckInEntity> roomCheckInEntities = roomCheckInRepo.findAll();

		if (!roomCheckInEntities.isEmpty()) {
			for (RoomCheckInEntity roomCheckInEntity : roomCheckInEntities)
				roomCheckInDto.getListResult().add(this.converter.toDTO(roomCheckInEntity, RoomCheckInDTO.class));

			roomCheckInDto.setMessage("Load room_check_in list successfully.");
			return roomCheckInDto;
		}

		return (RoomCheckInDTO) this.ExceptionObject(roomCheckInDto, "There is no any room_check_in.");
	}

	@Override
	public RoomCheckInDTO findOne(Long id) {
		RoomCheckInEntity roomCheckInEntity = roomCheckInRepo.findOne(id);
		if (roomCheckInEntity != null) {
			RoomCheckInDTO roomCheckInDto = this.converter.toDTO(roomCheckInEntity, RoomCheckInDTO.class);
			roomCheckInDto.setMessage("Get room_check_in having id = " + id + " successfully.");
			return roomCheckInDto;
		}

		return (RoomCheckInDTO) this.ExceptionObject(new RoomCheckInDTO(), "This room_check_in id does not exist.");
	}

	@Override
	public RoomCheckInDTO save(RoomCheckInDTO roomCheckInDto) {
		RoomCheckInEntity roomCheckInEntity = this.converter.toEntity(roomCheckInDto, RoomCheckInEntity.class);
		roomCheckInEntity = roomCheckInRepo.save(roomCheckInEntity);
		roomCheckInDto = this.converter.toDTO(roomCheckInEntity, RoomCheckInDTO.class);
		roomCheckInDto.setMessage("Save this room_check_in successfully.");
		return roomCheckInDto;
	}

	@Override
	public RoomCheckInDTO update(RoomCheckInDTO roomCheckInDto) {
		if (roomCheckInRepo.findOne(roomCheckInDto.getId()) != null) {
			RoomCheckInEntity roomCheckInEntity = this.converter.toEntity(roomCheckInDto, RoomCheckInEntity.class);
			roomCheckInDto = this.converter.toDTO(roomCheckInRepo.save(roomCheckInEntity), RoomCheckInDTO.class);
			roomCheckInDto.setMessage("Update this room_check_in successfully.");
			return roomCheckInDto;
		}
		
		return (RoomCheckInDTO)this.ExceptionObject(roomCheckInDto, "This room_check_in id does not exist.");
	}

	@Override
	public RoomCheckInDTO delete(Long id) {
		if (roomCheckInRepo.findOne(id) != null) {
			roomCheckInRepo.delete(id);
			RoomCheckInDTO roomCheckInDto = new RoomCheckInDTO();
			roomCheckInDto.setMessage("Delete room_check_in successfully.");
			return roomCheckInDto;
		}
		
		return (RoomCheckInDTO)this.ExceptionObject(new RoomCheckInDTO(), "This room_check_in id does not exist.");
	}

}
