package com.hotelmanagement.service.management;

import com.hotelmanagement.dto.CustomerDTO;

public interface ICustomerService extends IBaseService{

	CustomerDTO findAll();
	CustomerDTO findOne(Long id);
	CustomerDTO save(CustomerDTO customerDto);
	CustomerDTO update(CustomerDTO customerDto);
	CustomerDTO delete(Long id);
}
