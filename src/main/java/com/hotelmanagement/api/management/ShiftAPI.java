package com.hotelmanagement.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.dto.ShiftDTO;
import com.hotelmanagement.service.management.IShiftService;

@RestController
public class ShiftAPI {

	@Autowired
	private IShiftService shiftService;
	
	@GetMapping("/api/shift")
	public ResponseEntity<ShiftDTO> getShift() {
		ShiftDTO shiftDto = shiftService.findAll();
		return new ResponseEntity<ShiftDTO>(shiftDto, shiftDto.getHttpStatus());
	}
}
