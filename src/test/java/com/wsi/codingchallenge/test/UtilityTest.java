package com.wsi.codingchallenge.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static com.wsi.codingchallenge.Utility.*;

/**
 * Unit Test for Utility Class
 * 
 * @author Carlo Cochran <carlo.cochran@gmail.com>
 * @version 1.0
 *
 */
public class UtilityTest {
	
	@Test
	public void testIsValidZipCode() {
		assertEquals(isValidZipCode(null), false);
		assertEquals(isValidZipCode(""), false);
		assertEquals(isValidZipCode("1234"), false);		
		assertEquals(isValidZipCode("1234a"), false);
		assertEquals(isValidZipCode("123456"), false);
		assertEquals(isValidZipCode("12345-1234"), false);
		assertEquals(isValidZipCode("12345"), true);		
	}

}