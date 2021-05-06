package com.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.entity.TokenEntity;

public interface TokenRepository extends JpaRepository<TokenEntity, Long>{

	TokenEntity findOneByCode(String code);
}
