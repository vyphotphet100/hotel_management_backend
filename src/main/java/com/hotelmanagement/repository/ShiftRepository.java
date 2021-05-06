package com.hotelmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.entity.ShiftEntity;

public interface ShiftRepository extends JpaRepository<ShiftEntity, Long>{
	List<ShiftEntity> findAllByWeekday(Integer weekday);
}
