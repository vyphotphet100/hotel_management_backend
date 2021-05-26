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

import com.hotelmanagement.dto.RoomDTO;
import com.hotelmanagement.service.management.IRoomService;

@RestController
public class RoomAPI {

	@Autowired
	private IRoomService roomService;
	
	@GetMapping("/api/room")
	public ResponseEntity<RoomDTO> findAll() {
		RoomDTO roomDto = roomService.findAll();
		return new ResponseEntity<RoomDTO>(roomDto, roomDto.getHttpStatus());
	}
	
	@GetMapping("/api/room/{id}")
	public ResponseEntity<RoomDTO> findOne(@PathVariable("id") String id) {
		RoomDTO roomDto = roomService.findOne(id);
		return new ResponseEntity<RoomDTO>(roomDto, roomDto.getHttpStatus());
	}
	
	@PostMapping("/api/room")
	public ResponseEntity<RoomDTO> save(@RequestBody RoomDTO roomDto) {
		roomDto = roomService.save(roomDto);
		return new ResponseEntity<RoomDTO>(roomDto, roomDto.getHttpStatus());
	}
	
	@PutMapping("/api/room")
	public ResponseEntity<RoomDTO> update(@RequestBody RoomDTO roomDto) {
		roomDto = roomService.update(roomDto);
		return new ResponseEntity<RoomDTO>(roomDto, roomDto.getHttpStatus());
	}
	
	@DeleteMapping("/api/room/{id}")
	public ResponseEntity<RoomDTO> delete(@PathVariable("id") String id) {
		RoomDTO roomDto = roomService.delete(id);
		return new ResponseEntity<RoomDTO>(roomDto, roomDto.getHttpStatus());
	}
}
