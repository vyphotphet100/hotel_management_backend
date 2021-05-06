package com.hotelmanagement.service.management.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.dto.StaffDTO;
import com.hotelmanagement.dto.TokenDTO;
import com.hotelmanagement.service.management.ILoginService;
import com.hotelmanagement.service.management.IStaffService;
import com.hotelmanagement.service.management.ITokenService;
import com.hotelmanagement.utils.JwtUtil;

@Service
public class LoginService extends BaseService implements ILoginService{

	@Autowired 
	private IStaffService staffService;
	
	@Autowired
	private ITokenService tokenService;
	
	@Override
	public StaffDTO checkUser(StaffDTO staffDto) {
		StaffDTO resDto = staffService.findOneByUsernameAndPassword(staffDto.getUsername(), staffDto.getPassword());
		if (resDto != null) {
			String currentToken = resDto.getTokenCode();
			TokenDTO tokenDto = tokenService.findOneByCode(currentToken);
			
			String currentTokenTail = JwtUtil.getKeyTokenTail(currentToken);
			resDto.setTokenCode(currentTokenTail);
			String generatedToken = JwtUtil.generateToken(resDto);
			resDto.setTokenCode(generatedToken);
			tokenDto.setCode(generatedToken);
			tokenDto = tokenService.update(tokenDto);
			
			resDto.setMessage("Login successfully.");
			return resDto;
		}
			
		
		resDto = new StaffDTO();
		return (StaffDTO)this.ExceptionObject(resDto, "Username or password is invalid.");
	}

}
