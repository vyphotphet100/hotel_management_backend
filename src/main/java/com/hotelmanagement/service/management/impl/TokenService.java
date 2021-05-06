package com.hotelmanagement.service.management.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.dto.TokenDTO;
import com.hotelmanagement.entity.TokenEntity;
import com.hotelmanagement.repository.TokenRepository;
import com.hotelmanagement.service.management.ITokenService;

@Service
public class TokenService extends BaseService implements ITokenService{

	@Autowired 
	private TokenRepository tokenRepo;
	
	@Override
	public TokenDTO findOneByCode(String code) {
		return this.converter.toDTO(tokenRepo.findOneByCode(code), TokenDTO.class);
	}

	@Override
	public TokenDTO update(TokenDTO tokenDto) {
		if (tokenRepo.findOne(tokenDto.getId()) != null) {
			TokenEntity tokenEntity = this.converter.toEntity(tokenDto, TokenEntity.class);
			TokenEntity resEntity = tokenRepo.save(tokenEntity);
			TokenDTO resDto = this.converter.toDTO(resEntity, TokenDTO.class);
			resDto.setMessage("Update token successfully.");
			
			return resDto;
		}
		
		return (TokenDTO)this.ExceptionObject(tokenDto, "Token does not exist.");
	}

}
