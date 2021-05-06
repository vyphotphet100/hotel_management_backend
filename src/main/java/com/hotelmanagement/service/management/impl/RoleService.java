package com.hotelmanagement.service.management.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.dto.RoleDTO;
import com.hotelmanagement.entity.RoleEntity;
import com.hotelmanagement.repository.RoleRepository;
import com.hotelmanagement.service.management.IRoleService;

@Service
public class RoleService extends BaseService implements IRoleService{

	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public RoleDTO findAll() {
		RoleDTO roleDto = new RoleDTO();
		List<RoleEntity> roleEntities = roleRepo.findAll();
		
		if (!roleEntities.isEmpty()) {
			List<Object> roleDtos = new ArrayList<Object>();
			for (int i=0; i<roleEntities.size(); i++) 
				roleDtos.add(converter.toDTO(roleEntities.get(i), RoleDTO.class));
			roleDto.setListResult(roleDtos);
			roleDto.setMessage("Load Role list successfully.");
			
			return roleDto;
		}
		
		return (RoleDTO)this.ExceptionObject(roleDto, "Role list is empty.");
	}

	@Override
	public RoleDTO findOneByCode(String code) {
		return converter.toDTO(roleRepo.findOneByCode(code), RoleDTO.class);
	}

}
