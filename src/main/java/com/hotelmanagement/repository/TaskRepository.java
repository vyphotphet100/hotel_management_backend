package com.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long>{
	
	TaskEntity findOneByCode(String code);

}
