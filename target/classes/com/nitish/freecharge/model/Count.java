package com.nitish.freecharge.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Model Class (used to store count value for a given word)
 */
@XmlRootElement
public class Count {
	
	/** The count variable is used for storing the count of words from the file */
	private long count;

	/**
     * Method used to get the underlying count value by the object of this class
     *
     * @return long 
     */
	public long getCount() {
		return count;
	}

	/**
     * Method used to set the underlying count value by the object of this class
     * @param count the value of count to set
     */
	public void setCount(long count) {
		this.count = count;
	}

	/**
	 * Initializes a new Count object with count value passed in param
	 * @param count the value of count set to the newly created count object
	 */
	public Count(long count) {
		this.count = count;
	}

	/**
	 * Initializes a new Count object with default value of long as count's value
	 */
	public Count() {
	}
	
}
