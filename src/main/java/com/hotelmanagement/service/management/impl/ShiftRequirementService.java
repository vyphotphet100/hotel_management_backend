package com.hotelmanagement.service.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.dto.ShiftRequirementDTO;
import com.hotelmanagement.entity.ShiftRequirementEntity;
import com.hotelmanagement.repository.ShiftRequirementRepository;
import com.hotelmanagement.service.management.IShiftRequirementService;

@Service
public class ShiftRequirementService extends BaseService implements IShiftRequirementService {

	@Autowired
	private ShiftRequirementRepository shiftRequirementRepo;
	
	@Override
	public ShiftRequirementDTO findAll() {
		ShiftRequirementDTO shiftRequirementDto = new ShiftRequirementDTO();
		List<ShiftRequirementEntity> shiftRequirementEntities = shiftRequirementRepo.findAll();
		
		if (!shiftRequirementEntities.isEmpty()) {
			for (ShiftRequirementEntity shiftRequirementEntity : shiftRequirementEntities)
				shiftRequirementDto.getListResult().add(this.converter.toDTO(shiftRequirementEntity, ShiftRequirementDTO.class));
			
			shiftRequirementDto.setMessage("Load shift requirement successfully.");
			return shiftRequirementDto;
		}
		
		return (ShiftRequirementDTO) this.ExceptionObject(shiftRequirementDto, "There is no shift requirement.");	
		
	}

}
