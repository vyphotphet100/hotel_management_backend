package com.hotelmanagement.service.management.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.dto.StaffDTO;
import com.hotelmanagement.dto.TokenDTO;
import com.hotelmanagement.entity.StaffEntity;
import com.hotelmanagement.entity.TokenEntity;
import com.hotelmanagement.repository.StaffRepository;
import com.hotelmanagement.repository.TokenRepository;
import com.hotelmanagement.service.management.IStaffService;
import com.hotelmanagement.utils.JwtUtil;

@Service 
public class StaffService extends BaseService implements IStaffService{

	@Autowired
	private StaffRepository staffRepo;
	
	@Autowired
	private TokenRepository tokenRepo;
	
	@Override
	public StaffDTO findAll() {
		StaffDTO staffDto = new StaffDTO();
		List<StaffEntity> staffEntities = staffRepo.findAll();
		if (!staffEntities.isEmpty()) {
			List<Object> staffDtos = new ArrayList<Object>();
			for (int i=0; i<staffEntities.size(); i++)
				staffDtos.add(converter.toDTO(staffEntities.get(i), StaffDTO.class));
			staffDto.setListResult(staffDtos);
			staffDto.setMessage("Load Staff list successfully.");
			
			return staffDto;
		}
		
		return (StaffDTO)this.ExceptionObject(staffDto, "Staff list is empty.");
	}

	@Override
	public StaffDTO findOneByUsernameAndPassword(String username, String password) {
		return this.converter.toDTO(staffRepo.findOneByUsernameAndPassword(username, password), StaffDTO.class);
	}

	@Override
	public StaffDTO save(StaffDTO staffDto) {
		if (staffRepo.findOneByUsername(staffDto.getUsername()) == null) {
			// generate token
			TokenDTO tokenDto = new TokenDTO();
			tokenDto.setCode(JwtUtil.generateToken(staffDto));
			TokenEntity tokenEntity = tokenRepo.save(this.converter.toEntity(tokenDto, TokenEntity.class));
			staffDto.setTokenCode(tokenEntity.getCode());
			
			StaffEntity staffEntity = this.converter.toEntity(staffDto, StaffEntity.class);
			StaffDTO resDto = this.converter.toDTO(staffRepo.save(staffEntity), StaffDTO.class);
			resDto.setMessage("Add staff successfully!");
			return resDto;
		}
		
		return (StaffDTO)this.ExceptionObject(staffDto, "Staff exists already.");
		
	}

	@Override
	public StaffDTO delete(Long id) {
		StaffDTO staffDto = new StaffDTO();
		
		if (staffRepo.findOne(id) != null) {
			StaffEntity staffEntity = staffRepo.findOne(id);
			
			staffRepo.delete(id);
			tokenRepo.delete(staffEntity.getToken().getId());
			staffDto.setMessage("Delete staff successfully.");
			
			return staffDto;
		}
		
		return (StaffDTO)this.ExceptionObject(staffDto, "Staff does not exist.");
	}
	
	@Override
	public StaffDTO findOneByTokenCode(String tokenCode) {
		return this.converter.toDTO(staffRepo.findOneByTokenCode(tokenCode), StaffDTO.class);
	}

	@Override
	public StaffDTO update(StaffDTO staffDto) {
		if (staffRepo.findOne(staffDto.getId()) != null) {
			StaffEntity staffEntity = this.converter.toEntity(staffDto, StaffEntity.class);
			staffDto = this.converter.toDTO(staffRepo.save(staffEntity), StaffDTO.class);
			staffDto.setMessage("Update staff successfully.");
			
			return staffDto;
		}
		
		return (StaffDTO)this.ExceptionObject(staffDto, "Staff exists already.");
	}

	@Override
	public StaffDTO findOne(Long id) {
		StaffDTO staffDto = new StaffDTO();
		StaffEntity staffEntity = staffRepo.findOne(id);
		if (staffEntity != null) {
			staffDto = this.converter.toDTO(staffEntity, StaffDTO.class);
			staffDto.setMessage("Get staff having id=" + id + " successfully.");
			
			return staffDto;
		}
		
		return (StaffDTO)this.ExceptionObject(staffDto, "Staff having id=" + id + " is not found.");
	}

}
