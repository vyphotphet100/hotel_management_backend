package com.hotelmanagement.service.management;

import com.hotelmanagement.dto.CheckInDTO;

public interface ICheckInService extends IBaseService{
	
	CheckInDTO findOne(Long id);
	CheckInDTO findAll();
	CheckInDTO save(CheckInDTO checkInDto);

}
