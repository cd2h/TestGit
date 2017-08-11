package org.lrf.old_driver.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.lrf.old_driver.entity.User;
import org.lrf.old_driver.service.UserService;
import org.lrf.old_driver.util.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("register")
	public ModelAndView register(@ModelAttribute("user")User user,@RequestParam(name="verifyCode",required=false)String verifyCode,HttpSession session) {
		String originalPassword = user.getPassWord();
		
		Map<String, Object> result = userService.registerUser(user, verifyCode);
		
		if(result.get(Key.ERROR) == null) {
			return this.login(user.getUserName(), originalPassword, verifyCode, session);
		}else {
			return new ModelAndView("new",result);
		}
		
	}
	
	@PostMapping("login")
	public ModelAndView login(@RequestParam("loginName")String loginName,@RequestParam("passWord")String passWord,@RequestParam(required=false,name="verifyCode")String verifyCode,HttpSession session){
		Map<String, Object> result = userService.login(loginName, passWord, verifyCode,session);
			
		if(result.get(Key.ERROR) == null) {
			return new ModelAndView("index",result);
		}else {
			return new ModelAndView("new",result);
		}
	}
	
	@GetMapping("/logout")
	public ModelAndView login(HttpSession session){
		userService.logout(session);
		return new ModelAndView("redirect:new");
		
	}
	
	@RequestMapping("/new")
	public String showLogin(){
		return "new";
	}
	
	
}
