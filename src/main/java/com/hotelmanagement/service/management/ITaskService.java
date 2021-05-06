package com.hotelmanagement.service.management;

import com.hotelmanagement.dto.TaskDTO;

public interface ITaskService extends IBaseService {

	TaskDTO findOneByCode(String code);
}
