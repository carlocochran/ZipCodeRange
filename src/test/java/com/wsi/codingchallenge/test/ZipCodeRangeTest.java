package com.wsi.codingchallenge.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.wsi.codingchallenge.Range;
import com.wsi.codingchallenge.RangeException;
import com.wsi.codingchallenge.ZipCodeRange;

/**
 * Unit Test for ZipCodeRange Class
 * 
 * @author Carlo Cochran <carlo.cochran@gmail.com>
 * @version 1.0
 *
 */
public class ZipCodeRangeTest {
	
	private ZipCodeRange zcr = new ZipCodeRange();
	
	@Test(expected = RangeException.class)
	public void testMinimizeNull() throws RangeException{
		zcr.minimize(null);
	}
	
	@Test(expected = RangeException.class)
	public void testMinimizeEmpty() throws RangeException{
		zcr.minimize(new ArrayList<Range>());
	}

	@Test(expected = RangeException.class)
	public void testMinimizeInvalidStartZip() throws RangeException{
		List<Range> rangeList = new ArrayList<Range>();
		rangeList.add(new Range("1234a", "23456"));
		zcr.minimize(rangeList);
	}

	@Test(expected = RangeException.class)
	public void testMinimizeInvalidEndZip() throws RangeException{
		List<Range> rangeList = new ArrayList<Range>();
		rangeList.add(new Range("12345", "2345a"));
		zcr.minimize(rangeList);
	}
	
	@Test(expected = RangeException.class)
	public void testMinimizeInvalidZipRange() throws RangeException{
		List<Range> rangeList = new ArrayList<Range>();
		rangeList.add(new Range("23456", "12345"));
		zcr.minimize(rangeList);
	}
	
	@Test
	public void testMinimizeNoOverlap() throws RangeException{
		List<Range> rangeList = new ArrayList<Range>();
		rangeList.add(new Range("94133", "94133"));
		rangeList.add(new Range("94200", "94299"));
		rangeList.add(new Range("94600", "94699"));
		zcr.minimize(rangeList);
		assertEquals(rangeList.size(), 3);
		assert(rangeList.contains(new Range("94133", "94133")));
		assert(rangeList.contains(new Range("94200", "94299")));		
		assert(rangeList.contains(new Range("94600", "94699")));		
	}
	
	@Test
	public void testMinimizeWithOverlap1() throws RangeException{
		List<Range> rangeList = new ArrayList<Range>();
		rangeList.add(new Range("94133", "94133"));
		rangeList.add(new Range("94200", "94299"));
		rangeList.add(new Range("94226", "94399"));
		zcr.minimize(rangeList);
		assertEquals(rangeList.size(), 2);
		assert(rangeList.contains(new Range("94133", "94133")));
		assert(rangeList.contains(new Range("94200", "94399")));
	}

	@Test
	public void testMinimizeWithOverlap2() throws RangeException{
		List<Range> rangeList = new ArrayList<Range>();
		rangeList.add(new Range("94300", "94444"));
		rangeList.add(new Range("94200", "94299"));
		rangeList.add(new Range("94226", "94399"));
		zcr.minimize(rangeList);
		assertEquals(rangeList.size(), 1);
		assert(rangeList.contains(new Range("94200", "94444")));
	}
	
}
