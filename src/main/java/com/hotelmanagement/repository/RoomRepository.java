package com.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.entity.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, String>{

}
