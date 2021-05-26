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

import com.hotelmanagement.dto.CustomerDTO;
import com.hotelmanagement.service.management.ICustomerService;

@RestController
public class CustomerAPI {

	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/api/customer")
	public ResponseEntity<CustomerDTO> findAllCustomer() {
		CustomerDTO customerDto = customerService.findAll();
		return new ResponseEntity<CustomerDTO>(customerDto, customerDto.getHttpStatus());
	}
	
	@GetMapping("/api/customer/{id}")
	public ResponseEntity<CustomerDTO> findOneCustomer(@PathVariable("id") Long id) {
		CustomerDTO customerDto = customerService.findOne(id);
		return new ResponseEntity<CustomerDTO>(customerDto, customerDto.getHttpStatus());
	}
	
	@PostMapping("/api/customer")
	public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDto) {
		customerDto = customerService.save(customerDto);
		return new ResponseEntity<CustomerDTO>(customerDto, customerDto.getHttpStatus());
	}
	
	@PutMapping("/api/customer")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDto) {
		customerDto = customerService.update(customerDto);
		return new ResponseEntity<CustomerDTO>(customerDto, customerDto.getHttpStatus());
	}
	
	@DeleteMapping("/api/customer/{id}")
	public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") Long id) {
		CustomerDTO customerDto = customerService.delete(id);
		return new ResponseEntity<CustomerDTO>(customerDto, customerDto.getHttpStatus());
	}
}

