package org.lrf.old_driver.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lrf.old_driver.entity.City;
import org.lrf.old_driver.util.Key;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SetSelectedCityToResultMapInterceptor implements HandlerInterceptor{

	private City getSessionCity(HttpSession session) {
		Object cityObject = session.getAttribute(Key.CITY);
		if(cityObject == null) {
			return null;
		}else {
			return (City)cityObject;
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
		Object resultObj = arg3.getModel().get(Key.CITY);
		if(resultObj != null) {
			return;
		}else {
			City city = getSessionCity(arg0.getSession());
			if(city != null) {
				arg3.getModel().put(Key.CITY, city);
			}
		}		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		return true;
	}

	
}
