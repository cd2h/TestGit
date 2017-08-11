package org.lrf.old_driver.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lrf.old_driver.entity.User;
import org.lrf.old_driver.util.Key;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SetUserToResultMapInterceptor implements HandlerInterceptor{

	private User getSessionUser(HttpSession session) {
		Object userObject = session.getAttribute(Key.USER);
		if(userObject == null) {
			return null;
		}else {
			return (User)userObject;
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		if(arg3 == null)
			return;
		Object resultObj = arg3.getModel().get(Key.USER);
		if(resultObj != null) {
			return;
		}else {
			User user = getSessionUser(arg0.getSession());
			if(user != null) {
				arg3.getModel().put(Key.USER, user);
			}
		}		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		return true;
	}

	
}
