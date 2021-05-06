package com.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.entity.StaffEntity;

public interface StaffRepository extends JpaRepository<StaffEntity, Long>{

	StaffEntity findOneByUsernameAndPassword(String username, String password);
	StaffEntity findOneByUsername(String username);
	StaffEntity findOneByTokenCode(String tokenCode);
}
