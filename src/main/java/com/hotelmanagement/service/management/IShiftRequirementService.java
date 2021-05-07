package com.hotelmanagement.service.management;

import com.hotelmanagement.dto.ShiftRequirementDTO;

public interface IShiftRequirementService extends IBaseService {

	ShiftRequirementDTO findAll();
}
