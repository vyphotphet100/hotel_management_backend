package com.hotelmanagement.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.dto.CheckOutDTO;
import com.hotelmanagement.service.management.ICheckOutService;

@RestController
public class CheckOutAPI {
	
	@Autowired
	private ICheckOutService checkOutService;
	
	@GetMapping("/api/check_out")
	private ResponseEntity<CheckOutDTO> getCheckOut() {
		CheckOutDTO resDto = checkOutService.findAll();
		return new ResponseEntity<CheckOutDTO>(resDto, resDto.getHttpStatus());
	}
	
	@PostMapping("/api/check_out")
	private ResponseEntity<CheckOutDTO> postCheckOut(@RequestBody CheckOutDTO checkOutDto) {
		CheckOutDTO resDto = checkOutService.save(checkOutDto);
		return new ResponseEntity<CheckOutDTO>(resDto, resDto.getHttpStatus());
	}
}
