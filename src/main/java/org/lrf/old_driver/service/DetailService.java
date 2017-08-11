package org.lrf.old_driver.service;

import java.util.List;

import org.lrf.old_driver.entity.City;
import org.lrf.old_driver.entity.Comment;
import org.lrf.old_driver.entity.Detail;
import org.lrf.old_driver.entity.Page;
import org.lrf.old_driver.entity.Schedule;

public interface DetailService {
	public Detail createDetail(Detail detail);
	
	public Page<Detail> findDetailsPageByCityAndSex(City city,int sex,int pageNumber);
	
	public Detail findDetailById(String id);
	
	public List<Detail> findDetailsByUserId(String userId);
	
	public void addSchedule(String detailId,Schedule schedule);
	
	public void addComment(String detailId,Comment comment);
	
	public void changeStateCode(int stateCode);
	
	public Schedule evaluate(Integer appearance,Integer character,Integer quality,String  closingComments,String userId);
}
