package com.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.entity.RoomCheckInEntity;

public interface RoomCheckInRepository extends JpaRepository<RoomCheckInEntity, Long>{

}
