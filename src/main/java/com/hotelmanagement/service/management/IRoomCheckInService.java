package com.hotelmanagement.service.management;

import com.hotelmanagement.dto.RoomCheckInDTO;

public interface IRoomCheckInService extends IBaseService{

	RoomCheckInDTO findAll();
	RoomCheckInDTO findOne(Long id);
	RoomCheckInDTO save(RoomCheckInDTO roomCheckInDto);
	RoomCheckInDTO update(RoomCheckInDTO roomCheckInDto);
	RoomCheckInDTO delete(Long id);
}
