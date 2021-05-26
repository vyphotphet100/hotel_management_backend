package com.hotelmanagement.service.management;

import com.hotelmanagement.dto.RoomDTO;

public interface IRoomService extends IBaseService{

	RoomDTO findAll();
	RoomDTO findOne(String id);
	RoomDTO save(RoomDTO roomDto);
	RoomDTO update(RoomDTO roomDto);
	RoomDTO delete(String id);
}
