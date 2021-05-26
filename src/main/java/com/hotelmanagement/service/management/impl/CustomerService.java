package com.hotelmanagement.service.management.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.dto.CustomerDTO;
import com.hotelmanagement.entity.CustomerEntity;
import com.hotelmanagement.repository.CustomerRepository;
import com.hotelmanagement.service.management.ICustomerService;

@Service
public class CustomerService extends BaseService implements ICustomerService{

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public CustomerDTO findAll() {
		CustomerDTO customerDto = new CustomerDTO();
		List<CustomerEntity> customerEntities = customerRepo.findAll();
		
		if (!customerEntities.isEmpty()) {
			for (CustomerEntity customerEntity : customerEntities) 
				customerDto.getListResult().add(this.converter.toDTO(customerEntity, CustomerDTO.class));
			customerDto.setMessage("Load customer successfully.");
			return customerDto;
		}
		
		return (CustomerDTO)this.ExceptionObject(customerDto, "There is no any customer.");
	}

	@Override
	public CustomerDTO findOne(Long id) {
		CustomerDTO customerDto = new CustomerDTO();
		CustomerEntity customerEntity = customerRepo.findOne(id);
		if (customerEntity != null) {
			customerDto = this.converter.toDTO(customerEntity, CustomerDTO.class);
			customerDto.setMessage("Get customer having id = " + id + " successfully.");
			return customerDto;
		}
		
		return (CustomerDTO) this.ExceptionObject(customerDto, "This customer id does not exist.");
		
	}

	@Override
	public CustomerDTO save(CustomerDTO customerDto) {
		CustomerEntity customerEntity = this.converter.toEntity(customerDto, CustomerEntity.class);
		customerDto = this.converter.toDTO(customerRepo.save(customerEntity), CustomerDTO.class);
		customerDto.setMessage("Save customer successfully.");
		return customerDto;
	}

	@Override
	public CustomerDTO update(CustomerDTO customerDto) {
		if (customerRepo.findOne(customerDto.getId()) != null) {
			CustomerEntity customerEntity = customerRepo.save(this.converter.toEntity(customerDto, CustomerEntity.class));
			customerDto = this.converter.toDTO(customerEntity, CustomerDTO.class);
			customerDto.setMessage("Update customer having id = " + customerDto.getId() + " succesffully.");
			return customerDto;
		}
		
		return (CustomerDTO)this.ExceptionObject(customerDto, "This customer id does not exist.");
	}

	@Override
	public CustomerDTO delete(Long id) {
		CustomerDTO customerDto = new CustomerDTO();
		if (customerRepo.findOne(id) != null) {
			customerRepo.delete(id);
			customerDto.setMessage("Delete customer having id = " + id + " successfully.");
			return customerDto;
		}
		
		return (CustomerDTO)this.ExceptionObject(customerDto, "This customer id does not exist.");
	}

	
}
