package org.lrf.old_driver.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.lrf.old_driver.entity.City;
import org.lrf.old_driver.service.CityService;
import org.lrf.old_driver.util.CityStore;
import org.lrf.old_driver.util.JsonUtil;
import org.lrf.old_driver.util.Key;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component("cityService")
public class CityServiceImp implements CityService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<City> getAllCities() {
		String jsonPath = getClass().getClassLoader().getResource("cities.json").getPath();
		try {
			return new JsonUtil<City>(City.class).readListFromJson(jsonPath);
		} catch (JsonParseException e) {
			logger.error(e.getMessage(), e);
		} catch (JsonMappingException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 创建26字母的map，并放入空的list
	 * 
	 * @return
	 */
	private Map<String, List<City>> createCityMap() {
		Map<String, List<City>> citiesMap = new LinkedHashMap<>();
		// 新建list，放入map
		for (String firstChar : CityStore.ALL_FIRST_CHAR) {
			List<City> cities = new ArrayList<>();
			citiesMap.put(firstChar, cities);
		}
		return citiesMap;
	}

	private Map<String, List<City>> fromListToCitiesMap(List<City> allCitiesList) {
		Map<String, List<City>> cityMap = createCityMap();

		// 循环所有city，并把city放入map中的list里面去
		for (City city : allCitiesList) {
			city.putCityToList(cityMap);
		}

		return cityMap;
	}

	@Override
	public void setAllCities() {
		logger.info("城市初始化完毕!");
		List<City> allCity = getAllCities();
		CityStore.citiesList = allCity;
		CityStore.citiesMap = fromListToCitiesMap(allCity);
	}

	@Override
	public List<City> getCitiesByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<City> getMetropolis() {
		return CityStore.citiesMap.get(CityStore.METROPOLIS);
	}

	/**
	 * 按首字符排序
	 * 
	 * @param cities
	 */
	private void sortCities(List<City> cities) {
		Collections.sort(cities);
		logger.info("城市初排序完毕!");
	}

	@Override
	public Map<String, List<City>> getAllCity() {
		return CityStore.citiesMap;
	}

	@Override
	public City getCityByPinyin(String pinyin) {
		List<City> cities = CityStore.citiesMap.get(new String(new char[] { pinyin.toCharArray()[0] }).toUpperCase());
		for (City city : cities) {
			if (city.getPinyin().equals(pinyin)) {
				return city;
			}
		}
		return null;
	}

	@Override
	public void setCityByPinyin(String pinyin, HttpSession session) {
		session.setAttribute(Key.CITY, getCityByPinyin(pinyin));
	}

	@Override
	public List<City> searchCity(String key) {

		return CityStore.search(key);
	}
}
