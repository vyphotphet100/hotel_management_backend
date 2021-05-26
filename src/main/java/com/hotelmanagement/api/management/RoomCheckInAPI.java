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

import com.hotelmanagement.dto.RoomCheckInDTO;
import com.hotelmanagement.service.management.IRoomCheckInService;

@RestController
public class RoomCheckInAPI {

	@Autowired
	private IRoomCheckInService roomCheckInService;
	
	@GetMapping("/api/room_check_in")
	public ResponseEntity<RoomCheckInDTO> findAll() {
		RoomCheckInDTO roomCheckInDto = roomCheckInService.findAll();
		return new ResponseEntity<RoomCheckInDTO>(roomCheckInDto, roomCheckInDto.getHttpStatus());
	}
	
	@GetMapping("/api/room_check_in/{id}")
	public ResponseEntity<RoomCheckInDTO> findOne(@PathVariable("id") Long id) {
		RoomCheckInDTO roomCheckInDto = roomCheckInService.findOne(id);
		return new ResponseEntity<RoomCheckInDTO>(roomCheckInDto, roomCheckInDto.getHttpStatus());
	}
	
	@PostMapping("/api/room_check_in")
	public ResponseEntity<RoomCheckInDTO> save(@RequestBody RoomCheckInDTO roomCheckInDto) {
		roomCheckInDto = roomCheckInService.save(roomCheckInDto);
		return new ResponseEntity<RoomCheckInDTO>(roomCheckInDto, roomCheckInDto.getHttpStatus());
	}
	
	@PutMapping("/api/room_check_in")
	public ResponseEntity<RoomCheckInDTO> update(@RequestBody RoomCheckInDTO roomCheckInDto) {
		roomCheckInDto = roomCheckInService.update(roomCheckInDto);
		return new ResponseEntity<RoomCheckInDTO>(roomCheckInDto, roomCheckInDto.getHttpStatus());
	}
	
	@DeleteMapping("/api/room_check_in/{id}")
	public ResponseEntity<RoomCheckInDTO> delete(@PathVariable("id") Long id) {
		RoomCheckInDTO roomCheckInDto = roomCheckInService.delete(id);
		return new ResponseEntity<RoomCheckInDTO>(roomCheckInDto, roomCheckInDto.getHttpStatus());
	}
}
