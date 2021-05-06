package com.hotelmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.entity.CheckOutEntity;

public interface CheckOutRepository extends JpaRepository<CheckOutEntity, Long>{

	List<CheckOutEntity> findAllByStaffId(Long staffId);
}
