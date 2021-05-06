package com.hotelmanagement.service.management.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.converter.ShiftMapping;
import com.hotelmanagement.dto.StaffDTO;
import com.hotelmanagement.entity.CheckInEntity;
import com.hotelmanagement.entity.CheckOutEntity;
import com.hotelmanagement.entity.RecordEntity;
import com.hotelmanagement.entity.RoleEntity;
import com.hotelmanagement.entity.ShiftEntity;
import com.hotelmanagement.repository.CheckInRepository;
import com.hotelmanagement.repository.CheckOutRepository;
import com.hotelmanagement.repository.RecordRepository;
import com.hotelmanagement.repository.RoleRepository;
import com.hotelmanagement.repository.ShiftRepository;
import com.hotelmanagement.service.management.IRecordService;
import com.hotelmanagement.service.management.IStaffService;
import com.hotelmanagement.utils.MyUtil;

@Service
public class RecordService extends BaseService implements IRecordService {
	
	@Autowired
	private IStaffService staffService;

	@Autowired
	private CheckInRepository checkInRepo;

	@Autowired
	private CheckOutRepository checkOutRepo;

	@Autowired 
	private ShiftRepository shiftRepo;
	
	@Autowired
	private RecordRepository recordRepo;
	
	@Autowired 
	private RoleRepository roleRepo;

	@Override
	public void createRecordDaily() {
		Date dateNow = new Date();
		StaffDTO staffDto = staffService.findAll();
		List<Object> staffDtos = staffDto.getListResult();

		for (int i = 0; i < staffDtos.size(); i++) {
			RecordEntity recordEntity = new RecordEntity();

			// save date
			Date recordForDate = new Date();
			recordForDate.setTime(dateNow.getTime() - (24 * 3600 * 1000));
			recordEntity.setDate(recordForDate);

			// save Day of week
			recordEntity.setDayOfWeek(MyUtil.getDayOfWeek(recordForDate));

			// save staff_username
			recordEntity.setStaffUsername(((StaffDTO) staffDtos.get(i)).getUsername());

			// save staff_fullname
			recordEntity.setStaffFullname(((StaffDTO) staffDtos.get(i)).getFullname());

			// compute and save total working hour and compensation hour
			Integer workHour = 0;
			Integer compenHour = 0;
			// Get list check in and check out of this staff
			List<CheckInEntity> checkInEntities = checkInRepo.findAllByStaffId(((StaffDTO) staffDtos.get(i)).getId());
			List<CheckOutEntity> checkOutEntities = checkOutRepo
					.findAllByStaffId(((StaffDTO) staffDtos.get(i)).getId());
			// Consider for each check in and check out row
			long workHourL = 0;
			long compenHourL = 0;
			for (int k = 0; k < checkInEntities.size(); k++) {
				Date checkInTime = checkInEntities.get(k).getDate();
				Date checkOutTime = checkOutEntities.get(k).getDate();

				// if this shift is the shift of this staff then we compute working hour
				if (((StaffDTO) staffDtos.get(i)).getShiftIds()
						.contains(ShiftMapping.map(checkInEntities.get(k).getDate()))) {
					workHourL += checkOutTime.getTime() - checkInTime.getTime();
				}
				// if this shift is not the shift of this staff then we compute compensation hour
				else {
					compenHourL += checkOutTime.getTime() - checkInTime.getTime();
				}

			}
			workHour = (int) workHourL / (3600 * 1000);
			compenHour = (int) compenHourL / (3600 * 1000);
			recordEntity.setTotalWorkingHour(workHour);
			recordEntity.setTotalCompensationTime(compenHour);

			// compute and save resting hour
			Integer restHour = 0;
			// get day of week of today
			Integer weekday = MyUtil.getDayOfWeek(new Date());
			// find shift by day of week
			List<ShiftEntity> shiftEntities = shiftRepo.findAllByWeekday(weekday);
			// Create new list to save which shift of this day the staff work for
			List<Long> shifts = new ArrayList<Long>();
			if (((StaffDTO) staffDtos.get(i)).getShiftIds().contains(shiftEntities.get(0).getId())) {
				shifts.add(shiftEntities.get(0).getId());
			}
			if (((StaffDTO) staffDtos.get(i)).getShiftIds().contains(shiftEntities.get(1).getId())) {
				shifts.add(shiftEntities.get(1).getId());
			}
			// compute resting time
			if (shifts.size() == 1) {
				if (shifts.get(0) % 2 != 0)
					restHour = 12 - workHour;
				else
					restHour = 10 - workHour;
			} else if (shifts.size() == 1)
				restHour = 22 - workHour;
			// save
			recordEntity.setTotalRestingTime(restHour);
			
			// compute and save wage
			RoleEntity roleEntity = roleRepo.findOneByCode(((StaffDTO)staffDtos.get(i)).getRoleCode());
			Long wageEveryHour = roleEntity.getWageEveryHour();
			Long wage = workHour * wageEveryHour;
			recordEntity.setWage(wage);
			
			// compute and save fine
			Long fine = (wageEveryHour*2) * restHour;
			recordEntity.setFine(fine);
			
			//compute and save compensation wage
			Long compenWage = (wageEveryHour*2) * compenHour;
			recordEntity.setCompensationWage(compenWage);
			
			//compute and save total wage
			Long totalWage = compenWage + wage - fine;
			recordEntity.setTotalWage(totalWage);

			// save Record
			recordRepo.save(recordEntity);
			System.out.print("Save record for " + ((StaffDTO) staffDtos.get(i)).getUsername() + ".\n");
		}
	}

}
