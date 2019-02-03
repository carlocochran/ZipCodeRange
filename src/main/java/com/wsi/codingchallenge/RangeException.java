package com.wsi.codingchallenge;

/**
 * Custom Exception
 * 
 * @author Carlo Cochran <carlo.cochran@gmail.com>
 * @version 1.0
 */
public class RangeException extends Exception {

	private static final long serialVersionUID = 1L;

	public RangeException(String message) {
		super(message);
	}
}
