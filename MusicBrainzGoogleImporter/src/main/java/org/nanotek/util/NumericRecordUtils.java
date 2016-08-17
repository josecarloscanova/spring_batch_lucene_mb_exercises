package org.nanotek.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumericRecordUtils {

	public static boolean isNumber(String string) {
		Pattern pattern = Pattern.compile("^\\d+$");
		Matcher matcher = pattern.matcher(string);
		return (string!=null)?matcher.find():false;
	}

	public static Integer formatNumber(String string) {
		Integer num = 0; 
		try { 
			num = new Integer(string);
		}catch(Exception ex){}
		return num;
	}
	
}
