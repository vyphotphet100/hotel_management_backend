package com.hotelmanagement.service.management;

import com.hotelmanagement.dto.StaffDTO;

public interface ILoginService extends IBaseService {
	StaffDTO checkUser(StaffDTO staffDto);
}
