package com.hotelmanagement.converter;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.hotelmanagement.utils.MyUtil;

@Component
public class ShiftMapping {

	@SuppressWarnings("deprecation")
	public static Long map(Date date) {
		// get day of week on date
		Integer dayOfWeek = MyUtil.getDayOfWeek(date);
		
		// map to shift_id
		if (dayOfWeek == 1) {
			if (date.getHours() >= 7 && date.getHours() < 19)
				return 1L;
			else if (date.getHours() != 6 && date.getHours() != 19)
				return 2L;
		}
		else if (dayOfWeek == 2) {
			if (date.getHours() >= 7 && date.getHours() <= 19)
				return 3L;
			else if (date.getHours() != 6 && date.getHours() != 19)
				return 4L;
		}
		else if (dayOfWeek == 3) {
			if (date.getHours() >= 7 && date.getHours() <= 19)
				return 5L;
			else if (date.getHours() != 6 && date.getHours() != 19)
				return 6L;
		}
		else if (dayOfWeek == 4) {
			if (date.getHours() >= 7 && date.getHours() <= 19)
				return 7L;
			else if (date.getHours() != 6 && date.getHours() != 19)
				return 8L;
		}
		else if (dayOfWeek == 5) {
			if (date.getHours() >= 7 && date.getHours() <= 19)
				return 9L;
			else if (date.getHours() != 6 && date.getHours() != 19)
				return 10L;
		}
		else if (dayOfWeek == 6) {
			if (date.getHours() >= 7 && date.getHours() <= 19)
				return 11L;
			else if (date.getHours() != 6 && date.getHours() != 19)
				return 12L;
		}
		else if (dayOfWeek == 7) {
			if (date.getHours() >= 7 && date.getHours() <= 19)
				return 13L;
			else if (date.getHours() != 6 && date.getHours() != 19)
				return 14L;
		}
		
		return 0L;
	}

}
