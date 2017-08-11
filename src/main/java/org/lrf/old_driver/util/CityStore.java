package org.lrf.old_driver.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.lrf.old_driver.entity.City;

public class CityStore {

	private CityStore() {
	}

	public final static String METROPOLIS = "热门城市";
	public final static String[] ALL_FIRST_CHAR = new String[] { METROPOLIS, "A", "B", "C", "D", "E", "F", "G", "H",
			"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

	/**
	 * key city的pinyin首字母
	 */
	public static Map<String, List<City>> citiesMap;
	
	public static List<City> citiesList;

	/**
	 * 按照关键字模糊查询
	 * 
	 * @param key
	 *            关键字
	 * @return
	 */
	public static List<City> search(String key) {
		List<City> result = new ArrayList<>();
		for (City city : citiesList) {
			if (city.isInclusionKey(key.toLowerCase())) {
				result.add(city);
			}
		}
		return result;
	}

}
