package org.lrf.old_driver.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.lrf.old_driver.entity.City;

public interface CityService {
	public void setAllCities();
	
	public List<City> getCitiesByKeyword(String keyword);
	
	public List<City> getMetropolis();
	
	public Map<String, List<City>> getAllCity();
	
	public City getCityByPinyin(String pinyin);
	
	public void setCityByPinyin(String pinyin,HttpSession session);
	
	public List<City> searchCity(String key);
}
