package com.hotelmanagement.service.file.impl;

import org.springframework.http.HttpStatus;

import com.hotelmanagement.dto.BaseDTO;
import com.hotelmanagement.service.file.IBaseFileService;

public class BaseFileService implements IBaseFileService{
	@Override
	public BaseDTO ExceptionObject(BaseDTO dto, String message) {
		dto.setHttpStatus(HttpStatus.ALREADY_REPORTED);
		dto.setMessage(message);
		return dto;
	}
}
