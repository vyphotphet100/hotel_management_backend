package com.hotelmanagement.api.file;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.dto.FileDTO;
import com.hotelmanagement.service.file.IStaffFileService;

@RestController
public class StaffFileAPI {

	@Autowired
	private IStaffFileService staffFileService;
	
	@PostMapping("/api/file/staff/{id}")
	public ResponseEntity<FileDTO> postStaffFile(@RequestBody FileDTO fileDto, @PathVariable("id") Long id) {
		FileDTO resDto = staffFileService.upFile(id, fileDto);
		return new ResponseEntity<FileDTO>(resDto, resDto.getHttpStatus());
	}
	
	@GetMapping(value = "/api/file/staff/**", produces = MediaType.ALL_VALUE)
	@ResponseBody
	public byte[] getFile(HttpServletRequest request) throws IOException {
		return staffFileService.getFile(request.getRequestURI());
	}
}
