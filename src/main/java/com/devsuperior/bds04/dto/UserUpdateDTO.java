/**
 * 
 */
package com.devsuperior.bds04.dto;

import java.io.Serializable;

import com.devsuperior.bds04.services.validations.UserUpdateValid;

/**
 * @author Kalleo
 *
 */

@UserUpdateValid
public class UserUpdateDTO extends UserDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
