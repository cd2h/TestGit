package org.lrf.old_driver.controller;

import javax.servlet.http.HttpServletRequest;

import org.lrf.old_driver.util.Key;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/index")
	public String index(HttpServletRequest request){
		Object user = request.getAttribute(Key.USER);
		return "index";
	}
	
	@RequestMapping("/personal")
	public String person(){
		return "personal";
	}
	
	@RequestMapping("/policy")
	public String policy(){
		return "policy";
	}
	
	@RequestMapping("/publish_schedule")
	public String publish_schedule(){
		return "publish_schedule";
	}
	@RequestMapping("/publish")
	public String publish(){
		return "publish";
	}
	@RequestMapping("/nav")
	public String nav(){
		return "nav";
	}
	@RequestMapping("/agreement")
	public String agreement(){
		return "agreement";
	}
}
