package com.hotelmanagement.service.management;

import com.hotelmanagement.dto.RoleDTO;

public interface IRoleService extends IBaseService {
	
	RoleDTO findAll();
	RoleDTO findOneByCode(String code);

}
