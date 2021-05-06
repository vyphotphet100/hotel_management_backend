package com.hotelmanagement.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.dto.CheckInDTO;
import com.hotelmanagement.service.management.ICheckInService;

@RestController
public class CheckInAPI {
	
	@Autowired
	private ICheckInService checkInService;
	
	@GetMapping("/api/check_in")
	private ResponseEntity<CheckInDTO> getCheckIn() {
		CheckInDTO resDto = checkInService.findAll();
		return new ResponseEntity<CheckInDTO>(resDto, resDto.getHttpStatus());
	}
	
	@PostMapping("/api/check_in")
	private ResponseEntity<CheckInDTO> postCheckIn(@RequestBody CheckInDTO checkInDto) {
		CheckInDTO resDto = checkInService.save(checkInDto);
		return new ResponseEntity<CheckInDTO>(resDto, resDto.getHttpStatus());
	}
}
