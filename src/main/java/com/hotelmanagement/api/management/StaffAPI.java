package com.hotelmanagement.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.dto.StaffDTO;
import com.hotelmanagement.service.management.IStaffService;

@RestController
public class StaffAPI {

	@Autowired
	private IStaffService staffService;

	@GetMapping("/api/staff")
	public ResponseEntity<StaffDTO> getStaff() {
		StaffDTO staffDto = staffService.findAll();
		return new ResponseEntity<StaffDTO>(staffDto, staffDto.getHttpStatus());
	}

	@PostMapping("/api/staff")
	public ResponseEntity<StaffDTO> postStaff(@RequestBody StaffDTO staffDto) {
		StaffDTO resDto = staffService.save(staffDto);
		return new ResponseEntity<StaffDTO>(resDto, resDto.getHttpStatus());
	}
	
	@PutMapping("/api/staff")
	public ResponseEntity<StaffDTO> updateStaff(@RequestBody StaffDTO staffDto) {
		StaffDTO resDto = staffService.update(staffDto);
		return new ResponseEntity<StaffDTO>(resDto, resDto.getHttpStatus());
	}
	
	@DeleteMapping("/api/staff/{staffId}")
	public ResponseEntity<StaffDTO> deleteStaff(@PathVariable("staffId") Long staffId) {
		StaffDTO resDto = staffService.delete(staffId);
		return new ResponseEntity<StaffDTO>(resDto, resDto.getHttpStatus());
	}

}
