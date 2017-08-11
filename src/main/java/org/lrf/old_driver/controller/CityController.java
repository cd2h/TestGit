package org.lrf.old_driver.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.lrf.old_driver.entity.City;
import org.lrf.old_driver.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("cities")
	public ModelAndView cities() {
		
		Map<String, Object> result = new HashMap<>();
		result.put("cities", cityService.getAllCity());
		
		return new ModelAndView("show_cities",result);
	}
	
	@GetMapping("/city/{pinyin}")
	public ModelAndView selectCity(@PathVariable("pinyin")String pinyin,HttpSession session) {
		
		Map<String, Object> result = new HashMap<>();
		cityService.setCityByPinyin(pinyin, session);
		
		return new ModelAndView("redirect:/index",result);
	} 
	
	@RequestMapping("/search_city")
	@ResponseBody
	public List<City> searchCity(@RequestParam("key")String key){ 
		List<City> cities = cityService.searchCity(key);
		for (City city : cities) {
			System.out.println(city.getName());
		}
		return cities;
	}
	
	@RequestMapping("/get_metropolis")
	@ResponseBody
	public List<City> getMetropolis(){ 
		return cityService.getMetropolis();
	}
}
