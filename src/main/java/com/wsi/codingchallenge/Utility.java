package com.wsi.codingchallenge;

import java.util.regex.Pattern;

/**
 * Utility Class
 * 
 * @author Carlo Cochran <carlo.cochran@gmail.com>
 * @version 1.0
 */
public class Utility {
	
	/**
	 * 5 digit zip codes only (no 5-4 format) 
	 */
	private static String regex = "^[0-9]{5}?$";	
	
	/**
	 * Utility method to determine if input text is a valid 5 digit zip code
	 * @param input - text to validate
	 * @return true if input is a valid 5 digit zip code, false otherwise
	 */
	public static Boolean isValidZipCode(String input) {
		if (input == null) {
			return false;
		}
		return Pattern.matches(regex, input);
	}

}
