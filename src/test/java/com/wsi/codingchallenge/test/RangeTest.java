package com.wsi.codingchallenge.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.wsi.codingchallenge.Range;

/*
* Unit Test for Range Class
* 
* @author Carlo Cochran <carlo.cochran@gmail.com>
* @version 1.0
*
*/
public class RangeTest {
	
	@Test
	public void testToString() {
		Range range = new Range();
		range.setLowerBound("94200");
		range.setUpperBound("94444");
		assertEquals(range.toString(), "[94200,94444]");		
	}
	
	@Test
	public void testEquals() {
		assert(new Range("94200","94444").equals(new Range("94200","94444")));
	}
	
	@Test
	public void testNotEquals() {
		assert(!new Range("94200","94444").equals(new Range("94444","94200")));
	}	

}
