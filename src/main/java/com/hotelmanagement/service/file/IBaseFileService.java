package com.hotelmanagement.service.file;

import com.hotelmanagement.dto.BaseDTO;

public interface IBaseFileService {
	BaseDTO ExceptionObject(BaseDTO dto, String message);
}
