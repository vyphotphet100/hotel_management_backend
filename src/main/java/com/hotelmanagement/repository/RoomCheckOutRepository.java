package com.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.entity.RoomCheckOutEntity;

public interface RoomCheckOutRepository extends JpaRepository<RoomCheckOutEntity, Long>{

}
