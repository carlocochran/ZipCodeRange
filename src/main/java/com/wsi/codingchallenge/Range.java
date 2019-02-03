package com.wsi.codingchallenge;

/**
 * Bean class containing lower and upper bound range
 * 
 * @author Carlo Cochran <carlo.cochran@gmail.com>
 * @version 1.0
 */
public class Range {
	
	/**
	 * lower bound range
	 */
	private String lowerBound;
	
	/**
	 * upper bound range
	 */
	private String upperBound;
	
	/**
	 * Default constructor
	 */
	public Range() {
		
	}
	
	/**
	 * Overloaded constructor
	 * @param lowerBound - lower bound
	 * @param upperBound - upper bound
	 */
	public Range(String lowerBound, String upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	/**
	 * Getter for lower bound
	 * @return lowerBound
	 */
	public String getLowerBound() {
		return lowerBound;
	}
	
	/**
	 * Convenience method to return lower bound's Integer value, useful when comparing zip code ranges
	 * @return lowerBound as an Integer value
	 */
	public Integer getLowerBoundInt() {
		return Integer.parseInt(lowerBound);
	}
	
	/**
	 * Setter for lower bound
	 * @param lowerBound - lower bound to set
	 */
	public void setLowerBound(String lowerBound) {
		this.lowerBound = lowerBound;
	}
	
	/**
	 * Getter for upper bound
	 * @return upperBound
	 */
	public String getUpperBound() {
		return upperBound;
	}

	/**
	 * Convenience method to return upper bound's Integer value, useful when comparing zip code ranges
	 * @return upperBound as an Integer value
	 */	
	public Integer getUpperBoundInt() {
		return Integer.parseInt(upperBound);
	}
	
	/**
	 * Setter for upper bound
	 * @param upperBound - upper bound to set
	 */
	public void setUpperBound(String upperBound) {
		this.upperBound = upperBound;
	}

	/**
	 * Prints range with the following format: [lowerBound, upperBound]
	 */
	@Override
	public String toString() {
		return new StringBuffer()
				.append("[")
				.append(lowerBound)
				.append(",")
				.append(upperBound)
				.append("]")
				.toString();
	}	
	
	/**
	 * Custom equal method
	 */	
	@Override
    public boolean equals(Object o) { 
		if (o == this) { 
			return true;
		}
		
		if (!(o instanceof Range)) { 
			return false; 
		}
		
		Range range = (Range)o;	
		return this.hashCode() == range.hashCode();
	}
	
	/**
	 * Computes object hashcode; used in equals method
	 */
    @Override
    public int hashCode() {
        int prime1 = 31;
        int prime2 = 23;
        int startHashCode = lowerBound != null ? lowerBound.hashCode() : 1;
        int endHashCode = upperBound != null ? upperBound.hashCode() : 1;
        return (prime1 * startHashCode) + (prime2 * endHashCode);
    }	
}