package com.hotelmanagement.api.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.dto.RoleDTO;
import com.hotelmanagement.service.management.IRoleService;

@RestController
public class RoleAPI {
	
	@Autowired
	private IRoleService roleService;
	
	@GetMapping("/api/role")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public ResponseEntity<RoleDTO> getRole() {
		RoleDTO roleDto = roleService.findAll();
		return new ResponseEntity<RoleDTO>(roleDto, roleDto.getHttpStatus());
	}

}
