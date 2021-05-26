package com.hotelmanagement.service.management.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.hotelmanagement.converter.Converter;
import com.hotelmanagement.dto.BaseDTO;
import com.hotelmanagement.service.management.IBaseService;

public class BaseService implements IBaseService{

	@Autowired
	protected Converter converter;

	@Override
	public BaseDTO ExceptionObject(BaseDTO dto, String message) {
		
		dto.setHttpStatus(HttpStatus.ALREADY_REPORTED);
		dto.setMessage(message);
		return dto;
	}
}
