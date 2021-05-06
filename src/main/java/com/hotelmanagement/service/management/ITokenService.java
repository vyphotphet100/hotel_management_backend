package com.hotelmanagement.service.management;

import com.hotelmanagement.dto.TokenDTO;

public interface ITokenService extends IBaseService{

	TokenDTO findOneByCode(String code);
	TokenDTO update(TokenDTO tokenDto);
}
