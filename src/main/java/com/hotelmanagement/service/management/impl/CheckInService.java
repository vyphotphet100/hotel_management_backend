package com.hotelmanagement.service.management.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hotelmanagement.converter.ShiftMapping;
import com.hotelmanagement.dto.CheckInDTO;
import com.hotelmanagement.dto.StaffDTO;
import com.hotelmanagement.entity.CheckInEntity;
import com.hotelmanagement.entity.CheckOutEntity;
import com.hotelmanagement.repository.CheckInRepository;
import com.hotelmanagement.repository.CheckOutRepository;
import com.hotelmanagement.repository.StaffRepository;
import com.hotelmanagement.service.management.ICheckInService;
import com.hotelmanagement.service.management.IStaffService;

@Service
public class CheckInService extends BaseService implements ICheckInService {

	@Autowired
	private CheckInRepository checkInRepo;

	@Autowired
	private CheckOutRepository checkOutRepo;

	@Autowired
	private IStaffService staffService;

	@Autowired
	private StaffRepository staffRepo;

	@Override
	public CheckInDTO findOne(Long id) {
		return null;

	}

	@Override
	public CheckInDTO save(CheckInDTO checkInDto) {
		Date date = new Date();
		checkInDto.setDate(date);

		// check staff has this shift
		StaffDTO staffDto = staffService.findOne(checkInDto.getStaffId());
		if (staffDto.getHttpStatus() == HttpStatus.OK) {

			Long shiftId = ShiftMapping.map(checkInDto.getDate());
			if (!staffDto.getShiftIds().contains(shiftId)) {
				if (checkInDto.getListRequest().isEmpty())
					return (CheckInDTO) this.ExceptionObject(checkInDto, "This time is not your shift.");

				// get list check in of requesting staff
				StaffDTO reqStaffDto = this.converter.toDTO(
						staffRepo.findOneByUsername((String) checkInDto.getListRequest().get(0)), StaffDTO.class);
				List<CheckInEntity> checkIns = checkInRepo.findAllByStaffId(reqStaffDto.getId());
				Boolean isCoincident = false;
				for (int i = 0; i < checkIns.size(); i++) {
					Long reqStaffShiftId = ShiftMapping.map(checkIns.get(i).getDate());
					if (reqStaffShiftId == shiftId) {
						isCoincident = true;
						break;
					}
				}
				if (isCoincident)
					return (CheckInDTO) this.ExceptionObject(checkInDto, "This staff has checked in already.");
				if (!reqStaffDto.getShiftIds().contains(shiftId))
					return (CheckInDTO) this.ExceptionObject(checkInDto,
							"This time is not " + (String) checkInDto.getListRequest().get(0) + "'s shift.");

			}

		} else
			return (CheckInDTO) this.ExceptionObject(checkInDto, "Invalid staff_id.");

		// check if number of check-in equals check-out
		List<CheckInEntity> checkInEntities = checkInRepo.findAllByStaffId(checkInDto.getStaffId());
		List<CheckOutEntity> checkOutEntities = checkOutRepo.findAllByStaffId(checkInDto.getStaffId());

		if (checkInEntities.size() == checkOutEntities.size()) {
			CheckInEntity resEntity = checkInRepo.save(this.converter.toEntity(checkInDto, CheckInEntity.class));
			CheckInDTO resDto = this.converter.toDTO(resEntity, CheckInDTO.class);
			resDto.setMessage("Check in successfully.");

			return resDto;
		}

		return (CheckInDTO) this.ExceptionObject(checkInDto, "You did not check out.");
	}

	@Override
	public CheckInDTO findAll() {
		CheckInDTO checkInDto = new CheckInDTO();
		List<CheckInEntity> checkInEntities = checkInRepo.findAll();
		if (!checkInEntities.isEmpty()) {
			for (int i = 0; i < checkInEntities.size(); i++)
				checkInDto.getListResult().add(this.converter.toDTO(checkInEntities.get(i), CheckInDTO.class));
			checkInDto.setMessage("Load Check in list successfully.");

			return checkInDto;
		}

		return (CheckInDTO) this.ExceptionObject(checkInDto, "Check in list is empty.");
	}

}
