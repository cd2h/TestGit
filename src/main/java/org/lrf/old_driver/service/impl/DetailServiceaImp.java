package org.lrf.old_driver.service.impl;

import java.util.List;

import org.lrf.old_driver.entity.City;
import org.lrf.old_driver.entity.Comment;
import org.lrf.old_driver.entity.Detail;
import org.lrf.old_driver.entity.Page;
import org.lrf.old_driver.entity.Schedule;
import org.lrf.old_driver.service.DetailService;
import org.springframework.stereotype.Component;

@Component("detailService")
public class DetailServiceaImp implements DetailService {

	@Override
	public Detail createDetail(Detail detail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Detail> findDetailsPageByCityAndSex(City city, int sex, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Detail findDetailById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Detail> findDetailsByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSchedule(String detailId, Schedule schedule) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addComment(String detailId, Comment comment) {
		// TODO Auto-generated method stub

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

}
