package com.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.entity.RecordEntity;

public interface RecordRepository extends JpaRepository<RecordEntity, Long>{

}
