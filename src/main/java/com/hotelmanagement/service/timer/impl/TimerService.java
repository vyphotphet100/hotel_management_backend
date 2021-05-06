package com.hotelmanagement.service.timer.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotelmanagement.service.management.ICheckOutService;
import com.hotelmanagement.service.management.IRecordService;
import com.hotelmanagement.service.timer.ITimerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TimerService implements ITimerService {

	Date dateNow = new Date();
	Boolean isCheckOut = false;
	Boolean isGetRecord = false;
	
	@Autowired
	private ICheckOutService checkOutService;

	@Autowired
	private IRecordService recordService;

	@Scheduled(fixedRate = 10)
	@Override
	public void alwaysRun() {
		dateNow = new Date();
	}

	@SuppressWarnings("deprecation")
	@Transactional
	@Scheduled(fixedRate = 1000)
	@Override
	public void autoCheckOut() {
		//System.out.print(dateNow.toString() + "\n");
		
		if ((dateNow.getHours() == 6 || dateNow.getHours() == 19) && dateNow.getMinutes() == 0 && isCheckOut == false) {
			checkOutService.autoCheckOutForAllStaff();
			isCheckOut = true;
		}

		if ((dateNow.getHours() == 6 || dateNow.getHours() == 19) && dateNow.getMinutes() == 1 && isCheckOut == true)
			isCheckOut = false;

	}

	@SuppressWarnings("deprecation")
	@Transactional
	@Scheduled(fixedRate = 1000)
	@Override
	public void autoGetRecord() {
		if (dateNow.getHours() == 6 && dateNow.getMinutes() == 30 && isGetRecord == false) {
			recordService.createRecordDaily();
			isGetRecord = true;
		}

		if (dateNow.getHours() == 6 && dateNow.getMinutes() == 31 && isGetRecord == true)
			isGetRecord = false;

	}

}
