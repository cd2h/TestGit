package org.lrf.old_driver.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verify {
	public static boolean isMobileNO(String mobiles){  
		Pattern p = Pattern.compile("^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$");  
		Matcher m = p.matcher(mobiles);  
		return m.matches();  
	}
	
	/**
     * 判断正整数
     */
    public static boolean isPositiveInteger(String number){
        String reg = "^\\d+$";
        return Pattern.compile(reg).matcher(number).find();
    }
}
