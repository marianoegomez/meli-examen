package com.mercadolibre.examen.rest.services;

import com.mercadolibre.examen.rest.services.exceptions.ServiceException;
import com.mercadolibre.examen.rest.services.request.Request;
import com.mercadolibre.examen.rest.services.response.Response;

/**
 * @author Mariano
 *
 */
public interface Service {

	abstract public Response send(Request request) throws ServiceException;
	
}
