package com.devsuperior.bds04.services.exceptions;

/**
 * @author Kalleo
 *
 */
public class DatabaseException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DatabaseException(String msg) {
		super(msg);
	}
		
}
