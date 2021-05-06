package com.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	
	RoleEntity findOneByCode(String code);

}
