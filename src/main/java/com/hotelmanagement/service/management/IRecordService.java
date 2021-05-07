package com.hotelmanagement.service.management;

import com.hotelmanagement.dto.RecordDTO;

public interface IRecordService extends IBaseService{
	
	void createRecordDaily();
	RecordDTO findAll();

}
