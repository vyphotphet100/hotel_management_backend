package com.hotelmanagement.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.hotelmanagement.dto.CustomerDTO;
import com.hotelmanagement.dto.RoleDTO;
import com.hotelmanagement.dto.RoomCheckInDTO;
import com.hotelmanagement.dto.RoomCheckOutDTO;
import com.hotelmanagement.dto.RoomDTO;
import com.hotelmanagement.dto.ShiftDTO;
import com.hotelmanagement.dto.StaffDTO;
import com.hotelmanagement.dto.TokenDTO;
import com.hotelmanagement.entity.CheckInEntity;
import com.hotelmanagement.entity.CheckOutEntity;
import com.hotelmanagement.entity.CustomerEntity;
import com.hotelmanagement.entity.RoleEntity;
import com.hotelmanagement.entity.RoomCheckInEntity;
import com.hotelmanagement.entity.RoomCheckOutEntity;
import com.hotelmanagement.entity.RoomEntity;
import com.hotelmanagement.entity.ShiftEntity;
import com.hotelmanagement.entity.StaffEntity;
import com.hotelmanagement.entity.TokenEntity;
import com.hotelmanagement.repository.CheckInRepository;
import com.hotelmanagement.repository.CheckOutRepository;
import com.hotelmanagement.repository.CustomerRepository;
import com.hotelmanagement.repository.RoleRepository;
import com.hotelmanagement.repository.RoomCheckInRepository;
import com.hotelmanagement.repository.RoomCheckOutRepository;
import com.hotelmanagement.repository.RoomRepository;
import com.hotelmanagement.repository.ShiftRepository;
import com.hotelmanagement.repository.StaffRepository;
import com.hotelmanagement.repository.TokenRepository;

@Component
public class Converter {

	@Autowired
	private TokenRepository tokenRepo;

	@Autowired
	private ShiftRepository shiftRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private StaffRepository staffRepo;

	@Autowired
	private CheckInRepository checkInRepo;

	@Autowired
	private CheckOutRepository checkOutRepo;

	@Autowired
	private RoomCheckInRepository roomCheckInRepo;

	@Autowired
	private RoomCheckOutRepository roomCheckOutRepo;

	@Autowired
	private RoomRepository roomRepo;

	@Autowired
	private CustomerRepository customerRepo;

	public <T> T toDTO(Object entity, Class<T> tClass) {
		if (entity == null)
			return null;

		ModelMapper modelMap = new ModelMapper();
		T resObj = modelMap.map(entity, tClass);

		return this.dtoObject(entity, resObj);
	}

	public <T> T toEntity(Object dto, Class<T> tClass) {
		if (dto == null)
			return null;

		ModelMapper modelMap = new ModelMapper();
		T resObj = modelMap.map(dto, tClass);

		return this.entityObject(dto, resObj);
	}

	@SuppressWarnings("unchecked")
	private <T> T dtoObject(Object entity, T resObj) {

		if (resObj instanceof RoleDTO) {
			RoleDTO roleDto = (RoleDTO) resObj;
			RoleEntity roleEntity = (RoleEntity) entity;

			for (int i = 0; i < roleEntity.getStaffs().size(); i++)
				roleDto.getStaffUsernames().add(roleEntity.getStaffs().get(i).getUsername());

			for (int i = 0; i < roleEntity.getTasks().size(); i++)
				roleDto.getTaskCodes().add(roleEntity.getTasks().get(i).getCode());

			return (T) roleDto;
		} else if (resObj instanceof StaffDTO) {
			StaffDTO staffDto = (StaffDTO) resObj;
			StaffEntity staffEntity = (StaffEntity) entity;

			// set token code
			if (staffEntity.getToken() != null)
				staffDto.setTokenCode(staffEntity.getToken().getCode());

			// set list shift id
			if (staffEntity.getShifts() != null) {
				for (int i = 0; i < staffEntity.getShifts().size(); i++)
					staffDto.getShiftIds().add(staffEntity.getShifts().get(i).getId());
			}

			// set collection of authorities
			if (staffEntity.getRole() != null) {
				Collection<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority(staffEntity.getRole().getCode()));
				staffDto.setAuthorities(authorities);
			}

			// set checkInDates
			if (staffEntity.getCheckIns() != null) {
				for (int i = 0; i < staffEntity.getCheckIns().size(); i++) {
					Date date = staffEntity.getCheckIns().get(i).getDate();
					// date.setTime(date.getTime() - (7 * 3600)*1000);
					staffDto.getCheckInDates().add(date.toString());
				}

			}

			// set checkOuts
			if (staffEntity.getCheckOuts() != null) {
				for (int i = 0; i < staffEntity.getCheckOuts().size(); i++) {
					Date date = staffEntity.getCheckOuts().get(i).getDate();
					// date.setTime(date.getTime() - (7 * 3600)*1000);
					staffDto.getCheckOutDates().add(date.toString());
				}
			}

			return (T) staffDto;
		} else if (resObj instanceof TokenDTO) {
			TokenDTO tokenDto = (TokenDTO) resObj;
			TokenEntity tokenEntity = (TokenEntity) entity;

			if (tokenEntity.getStaff() != null)
				tokenDto.setStaffUsername(tokenEntity.getStaff().getUsername());

			return (T) tokenDto;
		} else if (resObj instanceof ShiftDTO) {
			ShiftDTO shiftDto = (ShiftDTO) resObj;
			ShiftEntity shiftEntity = (ShiftEntity) entity;

			if (shiftEntity.getStaffs() != null)
				for (StaffEntity staffEntity : shiftEntity.getStaffs())
					shiftDto.getStaffUsernames().add(staffEntity.getUsername());

			return (T) shiftDto;
		} else if (resObj instanceof CustomerDTO) {
			CustomerDTO customerDto = (CustomerDTO) resObj;
			CustomerEntity customerEntity = (CustomerEntity) entity;

			if (customerEntity.getRoomCheckIn() != null)
				customerDto.setRoomCheckInId(customerEntity.getRoomCheckIn().getId());

			if (customerEntity.getRoomCheckOut() != null)
				customerDto.setRoomCheckOutId(customerEntity.getRoomCheckOut().getId());

			return (T) customerDto;
		} else if (resObj instanceof RoomCheckInDTO) {
			RoomCheckInDTO roomCheckInDto = (RoomCheckInDTO) resObj;
			RoomCheckInEntity roomCheckInEntity = (RoomCheckInEntity) entity;

			if (roomCheckInEntity.getRoom() != null)
				roomCheckInDto.setRoomId(roomCheckInEntity.getRoom().getId());
			if (roomCheckInEntity.getCustomer() != null)
				roomCheckInDto.setCustomerId(roomCheckInEntity.getCustomer().getId());

			if (roomCheckInEntity.getStaffs() != null)
				for (StaffEntity staffEntity : roomCheckInEntity.getStaffs())
					roomCheckInDto.getStaffIds().add(staffEntity.getId());

			return (T) roomCheckInDto;
		} else if (resObj instanceof RoomCheckOutDTO) {
			RoomCheckOutDTO roomCheckOutDto = (RoomCheckOutDTO) resObj;
			RoomCheckOutEntity roomCheckOutEntity = (RoomCheckOutEntity) entity;

			if (roomCheckOutEntity.getRoom() != null)
				roomCheckOutDto.setRoomId(roomCheckOutEntity.getRoom().getId());
			if (roomCheckOutEntity.getCustomer() != null)
				roomCheckOutDto.setCustomerId(roomCheckOutEntity.getCustomer().getId());

			if (roomCheckOutEntity.getStaffs() != null)
				for (StaffEntity staffEntity : roomCheckOutEntity.getStaffs())
					roomCheckOutDto.getStaffIds().add(staffEntity.getId());

			return (T) roomCheckOutDto;
		} else if (resObj instanceof RoomDTO) {
			RoomDTO roomDto = (RoomDTO) resObj;
			RoomEntity roomEntity = (RoomEntity) entity;

			if (roomEntity.getRoomCheckIns() != null)
				for (RoomCheckInEntity roomCheckInEntity : roomEntity.getRoomCheckIns())
					roomDto.getRoomCheckInIds().add(roomCheckInEntity.getId());

			if (roomEntity.getRoomCheckOuts() != null)
				for (RoomCheckOutEntity roomCheckOutEntity : roomEntity.getRoomCheckOuts())
					roomDto.getRoomCheckOutIds().add(roomCheckOutEntity.getId());

			return (T) roomDto;
		}

		return resObj;
	}

	@SuppressWarnings("unchecked")
	private <T> T entityObject(Object dto, T resObj) {

		if (resObj instanceof RoleEntity) {

		} else if (resObj instanceof StaffEntity) {
			StaffEntity staffEntity = (StaffEntity) resObj;
			StaffDTO staffDto = (StaffDTO) dto;

			// set token
			if (staffDto.getTokenCode() != null) {
				TokenEntity tokenEntity = tokenRepo.findOneByCode(staffDto.getTokenCode());
				staffEntity.setToken(tokenEntity);
			}

			// set shift
			if (staffDto.getShiftIds() != null) {
				for (int i = 0; i < staffDto.getShiftIds().size(); i++)
					staffEntity.getShifts().add(shiftRepo.findOne(staffDto.getShiftIds().get(i)));
			}

			// set role
			if (staffDto.getRoleCode() != null) {
				RoleEntity roleEntity = roleRepo.findOneByCode(staffDto.getRoleCode());
				staffEntity.setRole(roleEntity);
			}

			// set checkIns
			if (staffDto.getCheckInDates() != null) {
				List<CheckInEntity> checkInEntities = checkInRepo.findAllByStaffId(staffDto.getId());
				for (int i = 0; i < checkInEntities.size(); i++) {
					staffEntity.getCheckIns().add(checkInEntities.get(i));
				}
			}

			// set checkOuts
			if (staffDto.getCheckOutDates() != null) {
				List<CheckOutEntity> checkOutEntities = checkOutRepo.findAllByStaffId(staffDto.getId());
				for (int i = 0; i < checkOutEntities.size(); i++) {
					staffEntity.getCheckOuts().add(checkOutEntities.get(i));
				}
			}

			return (T) staffEntity;
		} else if (resObj instanceof TokenEntity) {
			TokenEntity tokenEntity = (TokenEntity) resObj;
			TokenDTO tokenDto = (TokenDTO) dto;

			if (tokenDto.getStaffUsername() != null)
				tokenEntity.setStaff(staffRepo.findOneByUsername(tokenDto.getStaffUsername()));

			return (T) tokenEntity;
		} else if (resObj instanceof ShiftEntity) {
			ShiftEntity shiftEntity = (ShiftEntity) resObj;
			ShiftDTO shiftDto = (ShiftDTO) dto;

			if (shiftDto.getStaffUsernames() != null)
				for (String staffUsername : shiftDto.getStaffUsernames())
					shiftEntity.getStaffs().add(staffRepo.findOneByUsername(staffUsername));

			return (T) shiftEntity;
		} else if (resObj instanceof CustomerEntity) {
			CustomerEntity customerEntity = (CustomerEntity) resObj;
			CustomerDTO customerDto = (CustomerDTO) dto;

			if (customerDto.getRoomCheckInId() != null)
				customerEntity.setRoomCheckIn(roomCheckInRepo.findOne(customerDto.getRoomCheckInId()));
			if (customerDto.getRoomCheckOutId() != null)
				customerEntity.setRoomCheckOut(roomCheckOutRepo.findOne(customerDto.getRoomCheckOutId()));

			return (T) customerEntity;
		} else if (resObj instanceof RoomCheckInEntity) {
			RoomCheckInEntity roomCheckInEntity = (RoomCheckInEntity) resObj;
			RoomCheckInDTO roomCheckInDto = (RoomCheckInDTO) dto;

			if (roomCheckInDto.getRoomId() != null)
				roomCheckInEntity.setRoom(roomRepo.findOne(roomCheckInDto.getRoomId()));
			if (roomCheckInDto.getCustomerId() != null)
				roomCheckInEntity.setCustomer(customerRepo.findOne(roomCheckInDto.getCustomerId()));

			if (roomCheckInDto.getStaffIds() != null)
				for (Long staffEntityId : roomCheckInDto.getStaffIds())
					roomCheckInEntity.getStaffs().add(staffRepo.findOne(staffEntityId));

			return (T) roomCheckInEntity;
		} else if (resObj instanceof RoomCheckOutEntity) {
			RoomCheckOutEntity roomCheckOutEntity = (RoomCheckOutEntity) resObj;
			RoomCheckOutDTO roomCheckOutDto = (RoomCheckOutDTO) dto;

			if (roomCheckOutDto.getRoomId() != null)
				roomCheckOutEntity.setRoom(roomRepo.findOne(roomCheckOutDto.getRoomId()));
			if (roomCheckOutDto.getCustomerId() != null)
				roomCheckOutEntity.setCustomer(customerRepo.findOne(roomCheckOutDto.getCustomerId()));

			if (roomCheckOutDto.getStaffIds() != null)
				for (Long staffEntityId : roomCheckOutDto.getStaffIds())
					roomCheckOutEntity.getStaffs().add(staffRepo.findOne(staffEntityId));

			return (T) roomCheckOutEntity;
		} else if (resObj instanceof RoomEntity) {
			RoomEntity roomEntity = (RoomEntity) resObj;
			RoomDTO roomDto = (RoomDTO) dto;

			if (roomDto.getRoomCheckInIds() != null)
				for (Long roomCheckInId : roomDto.getRoomCheckInIds())
					roomEntity.getRoomCheckIns().add(roomCheckInRepo.findOne(roomCheckInId));

			if (roomDto.getRoomCheckOutIds() != null)
				for (Long roomCheckOutId : roomDto.getRoomCheckOutIds())
					roomEntity.getRoomCheckOuts().add(roomCheckOutRepo.findOne(roomCheckOutId));

			return (T) roomEntity;
		}

		return (T) resObj;
	}
}
