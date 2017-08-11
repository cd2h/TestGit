package org.lrf.old_driver.service;

import java.util.List;

import org.lrf.old_driver.entity.Schedule;

public interface ScheduleService {
	public Schedule createSchedule(String detailId,Schedule schedule);
	
	public List<Schedule> findSchedulesByUserId(String userId);
	
	public List<Schedule> findSchedulesByDetailId(String detailId);
	
	public void changeStateCode(int stateCode);
	
	public Schedule evaluate(Integer appearance,Integer character,Integer quality,String  closingComments,String userId);
	
	public Schedule addComment(String scheduleId,String userId);
}
