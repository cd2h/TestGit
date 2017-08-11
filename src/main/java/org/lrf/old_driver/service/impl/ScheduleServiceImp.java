package org.lrf.old_driver.service.impl;

import java.util.List;

import org.lrf.old_driver.entity.Schedule;
import org.lrf.old_driver.service.ScheduleService;

public class ScheduleServiceImp implements ScheduleService {

	@Override
	public Schedule createSchedule(String detailId, Schedule schedule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Schedule> findSchedulesByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Schedule> findSchedulesByDetailId(String detailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeStateCode(int stateCode) {
		// TODO Auto-generated method stub

	}

	@Override
	public Schedule evaluate(Integer appearance, Integer character, Integer quality, String closingComments,
			String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Schedule addComment(String scheduleId, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
