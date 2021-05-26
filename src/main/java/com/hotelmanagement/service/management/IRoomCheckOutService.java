package com.hotelmanagement.service.management;

import com.hotelmanagement.dto.RoomCheckOutDTO;

public interface IRoomCheckOutService extends IBaseService{

	RoomCheckOutDTO findAll();
	RoomCheckOutDTO findOne(Long id);
	RoomCheckOutDTO save(RoomCheckOutDTO roomCheckOutDto);
	RoomCheckOutDTO update(RoomCheckOutDTO roomCheckOutDto);
	RoomCheckOutDTO delete(Long id);
}
