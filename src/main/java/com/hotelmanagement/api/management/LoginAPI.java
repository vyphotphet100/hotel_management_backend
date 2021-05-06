package com.hotelmanagement.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.dto.StaffDTO;
import com.hotelmanagement.service.management.ILoginService;

@RestController
public class LoginAPI {
	
	@Autowired
	private ILoginService loginService;
	
	@PostMapping("/api/login")
	public ResponseEntity<StaffDTO> login(@RequestBody StaffDTO staffDto) {
		StaffDTO resDto = loginService.checkUser(staffDto);
		return new ResponseEntity<StaffDTO>(resDto, resDto.getHttpStatus());
	}

}
