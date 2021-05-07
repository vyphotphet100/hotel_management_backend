package com.hotelmanagement.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.dto.RecordDTO;
import com.hotelmanagement.service.management.IRecordService;

@RestController
public class RecordAPI {

	@Autowired
	private IRecordService recordService;
	
	@GetMapping("/api/record")
	public ResponseEntity<RecordDTO> getRecord() {
		RecordDTO recordDto = recordService.findAll();
		return new ResponseEntity<RecordDTO>(recordDto, recordDto.getHttpStatus());
	}
}
