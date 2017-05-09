package com.mercadolibre.examen.rest.services.exceptions;

/**
 * Representa una excepcion con los servicios rest.
 * 
 * @author Mariano
 *
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 8052105721409452991L;
	
	public ServiceException(String message) {
		super(message);
	}

}
