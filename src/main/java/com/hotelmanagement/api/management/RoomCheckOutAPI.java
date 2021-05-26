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

import com.hotelmanagement.dto.RoomCheckOutDTO;
import com.hotelmanagement.service.management.IRoomCheckOutService;

@RestController
public class RoomCheckOutAPI {

	@Autowired
	private IRoomCheckOutService roomCheckOutService;
	
	@GetMapping("/api/room_check_out")
	public ResponseEntity<RoomCheckOutDTO> findAll() {
		RoomCheckOutDTO roomCheckOutDto = roomCheckOutService.findAll();
		return new ResponseEntity<RoomCheckOutDTO>(roomCheckOutDto, roomCheckOutDto.getHttpStatus());
	}
	
	@GetMapping("/api/room_check_out/{id}")
	public ResponseEntity<RoomCheckOutDTO> findOne(@PathVariable("id") Long id) {
		RoomCheckOutDTO roomCheckOutDto = roomCheckOutService.findOne(id);
		return new ResponseEntity<RoomCheckOutDTO>(roomCheckOutDto, roomCheckOutDto.getHttpStatus());
	}
	
	@PostMapping("/api/room_check_out")
	public ResponseEntity<RoomCheckOutDTO> save(@RequestBody RoomCheckOutDTO roomCheckOutDto) {
		roomCheckOutDto = roomCheckOutService.save(roomCheckOutDto);
		return new ResponseEntity<RoomCheckOutDTO>(roomCheckOutDto, roomCheckOutDto.getHttpStatus());
	}
	
	@PutMapping("/api/room_check_out")
	public ResponseEntity<RoomCheckOutDTO> update(@RequestBody RoomCheckOutDTO roomCheckOutDto) {
		roomCheckOutDto = roomCheckOutService.update(roomCheckOutDto);
		return new ResponseEntity<RoomCheckOutDTO>(roomCheckOutDto, roomCheckOutDto.getHttpStatus());
	}
	
	@DeleteMapping("/api/room_check_out/{id}")
	public ResponseEntity<RoomCheckOutDTO> delete(@PathVariable("id") Long id) {
		RoomCheckOutDTO roomCheckOutDto = roomCheckOutService.delete(id);
		return new ResponseEntity<RoomCheckOutDTO>(roomCheckOutDto, roomCheckOutDto.getHttpStatus());
	}
}
