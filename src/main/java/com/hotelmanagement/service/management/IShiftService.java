package com.hotelmanagement.service.management;

import com.hotelmanagement.dto.ShiftDTO;

public interface IShiftService extends IBaseService {

	ShiftDTO findAll();
}
