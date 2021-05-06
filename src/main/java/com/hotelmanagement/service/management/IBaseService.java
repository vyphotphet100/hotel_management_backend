package com.hotelmanagement.service.management;

import com.hotelmanagement.dto.BaseDTO;

public interface IBaseService {
	
	BaseDTO ExceptionObject(BaseDTO dto, String message);

}
