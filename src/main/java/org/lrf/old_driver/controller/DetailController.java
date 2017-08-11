package org.lrf.old_driver.controller;

import org.lrf.old_driver.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/detail")
public class DetailController {
	
	@Autowired
	private DetailService detailService;
	
	@RequestMapping("/new")
	public ModelAndView newDetail() {
		return new ModelAndView("publish");
	}
}
