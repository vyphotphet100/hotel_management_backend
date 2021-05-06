package com.hotelmanagement.service.management.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagement.dto.TaskDTO;
import com.hotelmanagement.repository.TaskRepository;
import com.hotelmanagement.service.management.ITaskService;

@Service
public class TaskService extends BaseService implements ITaskService{

	@Autowired 
	private TaskRepository taskRepo;
	
	@Override
	public TaskDTO findOneByCode(String code) {
		return this.converter.toDTO(taskRepo.findOneByCode(code), TaskDTO.class);
	}

}
