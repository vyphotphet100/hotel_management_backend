package com.hotelmanagement.service.management.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hotelmanagement.dto.CheckOutDTO;
import com.hotelmanagement.dto.StaffDTO;
import com.hotelmanagement.entity.CheckInEntity;
import com.hotelmanagement.entity.CheckOutEntity;
import com.hotelmanagement.repository.CheckInRepository;
import com.hotelmanagement.repository.CheckOutRepository;
import com.hotelmanagement.service.management.ICheckOutService;
import com.hotelmanagement.service.management.IStaffService;

@Service
public class CheckOutService extends BaseService implements ICheckOutService {

	@Autowired
	private CheckOutRepository checkOutRepo;
	
	@Autowired
	private CheckInRepository checkInRepo;
	
	@Autowired
	private IStaffService staffService;

	@Override
	public CheckOutDTO save(CheckOutDTO checkOutDto) {
		Date date = new Date();
		checkOutDto.setDate(date);
		// check if number of check-in equals check-out
		List<CheckInEntity> checkInEntities = checkInRepo.findAllByStaffId(checkOutDto.getStaffId());
		List<CheckOutEntity> checkOutEntities = checkOutRepo.findAllByStaffId(checkOutDto.getStaffId());

		if (checkInEntities.size() > checkOutEntities.size()) {
			CheckOutEntity resEntity = checkOutRepo.save(this.converter.toEntity(checkOutDto, CheckOutEntity.class));
			CheckOutDTO resDto = this.converter.toDTO(resEntity, CheckOutDTO.class);
			resDto.setMessage("Check out successfully.");

			return resDto;
		}

		return (CheckOutDTO) this.ExceptionObject(checkOutDto, "You did not check in.");

		
	}

	@Override
	public CheckOutDTO findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckOutDTO findAll() {
		CheckOutDTO checkOutDto = new CheckOutDTO();
		List<CheckOutEntity> checkOutEntities = checkOutRepo.findAll();
		if (!checkOutEntities.isEmpty()) {
			for (int i = 0; i < checkOutEntities.size(); i++)
				checkOutDto.getListResult().add(this.converter.toDTO(checkOutEntities.get(i), CheckOutDTO.class));
			checkOutDto.setMessage("Load Check out list successfully.");

			return checkOutDto;
		}

		return (CheckOutDTO) this.ExceptionObject(checkOutDto, "Check out list is empty.");
	}

	@Override
	public void autoCheckOutForAllStaff() {
		StaffDTO staffDto = staffService.findAll();
		for (int i = 0; i < staffDto.getListResult().size(); i++) {
			CheckOutDTO checkOutDto = new CheckOutDTO();
			checkOutDto.setStaffId(((StaffDTO) staffDto.getListResult().get(i)).getId());
			CheckOutDTO checkedOutDto = this.save(checkOutDto);
			if (checkedOutDto.getHttpStatus() == HttpStatus.OK)
				System.out.print("Checked out for staff: "
						+ ((StaffDTO) staffDto.getListResult().get(i)).getUsername() + "\n");
		}
		
	}

}
