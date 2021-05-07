package com.hotelmanagement.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.dto.ShiftRequirementDTO;
import com.hotelmanagement.service.management.IShiftRequirementService;

@RestController
public class ShiftRequirementAPI {

	@Autowired
	private IShiftRequirementService shiftRequirementService;
	
	@GetMapping("/api/shift_requirement")
	private ResponseEntity<ShiftRequirementDTO> getShiftRequirement() {
		ShiftRequirementDTO shiftRequirementDto = shiftRequirementService.findAll();
		return new ResponseEntity<ShiftRequirementDTO>(shiftRequirementDto, shiftRequirementDto.getHttpStatus());
	}
}
