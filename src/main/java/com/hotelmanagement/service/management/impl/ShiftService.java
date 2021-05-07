package com.hotelmanagement.service.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.dto.ShiftDTO;
import com.hotelmanagement.entity.ShiftEntity;
import com.hotelmanagement.repository.ShiftRepository;
import com.hotelmanagement.service.management.IShiftService;

@Service
public class ShiftService extends BaseService implements IShiftService{

	@Autowired
	private ShiftRepository shiftRepo;
	
	@Override
	public ShiftDTO findAll() {
		ShiftDTO shiftDto = new ShiftDTO();
		List<ShiftEntity> shiftEntities = shiftRepo.findAll();
		
		if (!shiftEntities.isEmpty()) {
			for (ShiftEntity shiftEntity : shiftEntities)
				shiftDto.getListResult().add(this.converter.toDTO(shiftEntity, ShiftDTO.class));
			
			shiftDto.setMessage("Load shift list successfully.");
			return shiftDto;
		}
		
		return (ShiftDTO)this.ExceptionObject(shiftDto, "There is no shift.");
	}

}
