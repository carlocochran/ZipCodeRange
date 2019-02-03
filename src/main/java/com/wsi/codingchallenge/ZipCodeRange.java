package com.wsi.codingchallenge;

import java.util.List;

/**
 * ZipCodeRange Class
 * 
 * Code accepts a List of Range input and generates a minimized version based on zip code overlaps
 * 
 * EXAMPLES:
 * If the input = [94133,94133] [94200,94299] [94600,94699]
 * Then the output should be = [94133,94133] [94200,94299] [94600,94699]
 *
 * If the input = [94133,94133] [94200,94299] [94226,94399] 
 * Then the output should be = [94133,94133] [94200,94399]
 * 
 * ASSUMPTION:
 *    Zip codes are 5 digits only (no 5-4 variety)
 * 
 * @author Carlo Cochran <carlo.cochran@gmail.com>
 * @version 1.0
 */
public class ZipCodeRange {
	
	/**
	 * Validates range input before processing
	 * 
	 * Time Complexity: O(1)
	 * Space Complexity: O(n)
	 * 
	 * @param zipRangeList - List of Range to validate
	 * @return true if List passed validation
	 * @throws RangeException - validation error occurred
	 */
	private Boolean validate(List<Range> zipRangeList) throws RangeException{
		if ((zipRangeList == null) || (zipRangeList.size() == 0)) {
			throw new RangeException("List is empty");
		}
		for (Range range : zipRangeList) {
			if (!Utility.isValidZipCode(range.getLowerBound())) {
				throw new RangeException("Invalid Lower Bound: "+range.getLowerBound());
			}
			if (!Utility.isValidZipCode(range.getUpperBound())) {
				throw new RangeException("Invalid Upper Bound: "+range.getUpperBound());
			}
			if (range.getLowerBoundInt() > range.getUpperBoundInt()) {
				throw new RangeException("Lower Bound "+range.getLowerBound() +" should come before Upper Bound "+range.getUpperBound());
			}
		}
		return true;
	}
	
	/**
	 * Merge two ranges into one range if they have any zip code overlap
	 * 
	 * Time Complexity: O(1) - linear comparison
	 * Space Complexity: O(3) - uses 3 Range objects only: r1, r2 and new Range
	 * 
	 * @param r1 - first range
	 * @param r2 - second range
	 * @return new Range containing zip codes that covers both parameters; null if there are no overlaps
	 */
	private Range merge(Range r1, Range r2){
		// Found an overlap between two ranges
		if (r1.getLowerBoundInt() <= r2.getLowerBoundInt() && r2.getLowerBoundInt() <= r1.getUpperBoundInt()) {
			if (r1.getUpperBoundInt() <= r2.getUpperBoundInt()) {
				return new Range(r1.getLowerBound(), r2.getUpperBound());
			}
			else {
				return new Range(r1.getLowerBound(), r1.getUpperBound());
			}			
		}
		else if (r2.getLowerBoundInt() <= r1.getLowerBoundInt() && r1.getLowerBoundInt() <= r2.getUpperBoundInt()) {
			if (r2.getUpperBoundInt() <= r1.getUpperBoundInt()) {
				return new Range(r2.getLowerBound(), r1.getUpperBound());
			}
			else {
				return new Range(r2.getLowerBound(), r2.getUpperBound());
			}
		}	
		else {
			// No overlap found 
			return null;	
		}
	}
	

	/**
	 * Generate a minimized version of List based on zip code overlaps
	 * 
	 * ALGORIGHTM:
	 * 1. First index (int i) points to the range at the start of the list
	 * 2. Second index (int j) points to the range at the start of the list
	 * 3. Are both indices pointing to the same range?
	 * 		TRUE: shift second index to the right, repeat step 3
	 * 		FALSE: continue to step 4
	 * 4. Are there any overlaps between the two ranges?
	 *	    TRUE: override first index with merged range, remove range from second index and shift to the right
	 *	    FALSE: shift second index to the right
	 * 5. Repeat step 4 unless second index made it to the end of the list
	 * 6. Shift first index to the right
	 * 7. Repeat step 2 unless first index made it to the end of the list
	 * 
	 * 
	 * Time Complexity: O(n^2) - worst case scenario is list containing no range overlaps
	 * Space Complexity: O(n)
	 * 
	 * @param rangeList - List of Range objects to minimize
	 * @throws RangeException - if any validation error occurred
	 */
	public void minimize(List<Range> rangeList) throws RangeException{
		validate(rangeList);
		
		int i = 0;
		int size = rangeList.size();
		
		/*
		 * using a while loop instead of enhanced for-loop to prevent ConcurrentModificationException
		 * this method updates & removes item from List while iterating
		 */
		while (i < size) {
			Range r1 = rangeList.get(i);
			int j = 0;
			while (j < size) {
				if (i == j || i >= size) {
					j++;
					continue;
				}
				Range r2 = rangeList.get(j);
				Range mergedRange = merge(r1, r2);
				if (mergedRange != null) {
					rangeList.set(i, mergedRange);
					rangeList.remove(j);
					size = rangeList.size();
				}
				else {
					j++;
				}
			}
			i++;
		}
	}
	
}