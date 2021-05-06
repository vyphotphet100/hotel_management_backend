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

import com.hotelmanagement.dto.RoleDTO;
import com.hotelmanagement.dto.StaffDTO;
import com.hotelmanagement.dto.TokenDTO;
import com.hotelmanagement.entity.CheckInEntity;
import com.hotelmanagement.entity.CheckOutEntity;
import com.hotelmanagement.entity.RoleEntity;
import com.hotelmanagement.entity.StaffEntity;
import com.hotelmanagement.entity.TokenEntity;
import com.hotelmanagement.repository.CheckInRepository;
import com.hotelmanagement.repository.CheckOutRepository;
import com.hotelmanagement.repository.RoleRepository;
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

			roleDto.getStaffUsernames().clear();
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
					//date.setTime(date.getTime() - (7 * 3600)*1000);
					staffDto.getCheckInDates().add(date.toString());
				}
					
			}

			// set checkOuts
			if (staffEntity.getCheckOuts() != null) {
				for (int i = 0; i < staffEntity.getCheckOuts().size(); i++) {
					Date date = staffEntity.getCheckOuts().get(i).getDate();
					//date.setTime(date.getTime() - (7 * 3600)*1000);
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
		}

		return (T) resObj;
	}
}
