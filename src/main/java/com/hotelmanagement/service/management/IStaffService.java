package com.hotelmanagement.service.management;

import com.hotelmanagement.dto.StaffDTO;

public interface IStaffService extends IBaseService {

	StaffDTO findAll();
	StaffDTO findOneByUsernameAndPassword(String username, String password);
	StaffDTO findOneByTokenCode(String tokenCode);
	StaffDTO findOne(Long id);
	StaffDTO save(StaffDTO staffDto);
	StaffDTO update(StaffDTO staffDto);
	StaffDTO delete(Long id);
}
