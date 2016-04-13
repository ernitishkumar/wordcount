package com.nitish.freecharge.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model Class (used to store count value for a given word)
 */
@XmlRootElement
public class Error {
	
	/** The count variable is used for storing error messages */
	private String message;

	/**
	 * Method used to get the underlying error message value
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Method used to set the underlying error message 
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Initializes a new Error object with error message passed in param
	 * @param message
	 */
	public Error(String message) {
		this.message = message;
	}

	/**
	 * Initializes a new Error object with no error message
	 */
	public Error() {
	}
	
}
