package com.hotelmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.entity.CheckInEntity;

public interface CheckInRepository extends JpaRepository<CheckInEntity, Long>{

	List<CheckInEntity> findAllByStaffId(Long staffId);
}
