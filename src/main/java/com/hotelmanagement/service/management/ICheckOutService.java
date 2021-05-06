package com.hotelmanagement.service.management;

import com.hotelmanagement.dto.CheckOutDTO;

public interface ICheckOutService extends IBaseService {
	
	CheckOutDTO findOne(Long id);
	CheckOutDTO findAll();
	CheckOutDTO save(CheckOutDTO checkOutDto);
	void autoCheckOutForAllStaff();

}
