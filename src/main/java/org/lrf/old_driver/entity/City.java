package org.lrf.old_driver.entity;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.lrf.old_driver.util.CityStore;

public class City implements Comparable<City> {

	class User {
		public User() {
			System.out.println("user");
		}

	}

	class Teacher extends User {
		public Teacher() {
			System.out.println("teacher");
		}

	}
	
	public static void main(String[] args) {
		User user = new City().new Teacher();
		
	}

	/** private int id; */
	private String label;
	private String name;
	private String pinyin;
	private int zip;
	private boolean isMetropolis;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public boolean isMetropolis() {
		return isMetropolis;
	}

	public void setMetropolis(boolean isMetropolis) {
		this.isMetropolis = isMetropolis;
	}

	/**
	 * 比较两个字符串的首字符
	 * 
	 */
	@Override
	public int compareTo(City o) {
		if (this.pinyin == null || o.pinyin == null) {
			return 0;
		}

		if (this.pinyin.toCharArray()[0] > o.pinyin.toCharArray()[0])
			return 1;
		else if (this.pinyin.toCharArray()[0] < o.pinyin.toCharArray()[0])
			return -1;
		else
			return 0;
	}

	/**
	 * 获取拼音首字母
	 * 
	 * @return
	 */
	public String getPingyinFirstChar() {
		if (this.getPinyin() == null || this.getPinyin().isEmpty())
			return "";
		char[] firstChar = new char[] { this.getPinyin().toCharArray()[0] };
		return new String(firstChar).toUpperCase();
	}

	/**
	 * 把city存入list
	 * 
	 * @return
	 */
	public void putCityToList(Map<String, List<City>> citiesMap) {
		List<City> cities = citiesMap.get(getPingyinFirstChar());
		cities.add(this);
		setToMetropolisList(citiesMap);
	}

	/**
	 * 吧热门城市放入list
	 * 
	 * @param citiesMap
	 */
	public void setToMetropolisList(Map<String, List<City>> citiesMap) {
		if (this.isMetropolis())
			citiesMap.get(CityStore.METROPOLIS).add(this);
	}

	/**
	 * label 是否包含key
	 * 
	 * @param key
	 *            查询的关键字
	 * @param regulaer
	 *            查询的规则
	 * @return
	 */
	public boolean isInclusionKey(String key) {
		Pattern pattern = Pattern.compile(".*" + key + ".*");
		Matcher matcher = pattern.matcher(this.getLabel().toLowerCase());
		return matcher.find();
	}
}
