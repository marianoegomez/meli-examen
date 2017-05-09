package com.mercadolibre.examen.rest.services.impl;

import org.codehaus.jackson.map.ObjectMapper;

import com.mercadolibre.examen.rest.services.BaseRestService;
import com.mercadolibre.examen.rest.services.exceptions.ServiceException;
import com.mercadolibre.examen.rest.services.request.Request;
import com.mercadolibre.examen.rest.services.request.RetrieveCountryDataRequest;
import com.mercadolibre.examen.rest.services.response.Response;
import com.mercadolibre.examen.rest.services.response.RetrieveCountryDataResponse;
import com.sun.jersey.api.client.ClientResponse;

/**
 * Clase que implementa la invocacion especifica del servicio restcountries
 * 
 * @author Mariano
 */
public class RetrieveCountryDataServiceImpl extends BaseRestService  {

	private static final String URL = "https://restcountries.eu/rest/v2/alpha/";
	
	public Response send(Request request) throws ServiceException {
		try {

			ClientResponse response = createRequest(this.getURL(((RetrieveCountryDataRequest)request).getCountryCode()));
			
			String json = response.getEntity(String.class);
			ObjectMapper mapper = new ObjectMapper();
			RetrieveCountryDataResponse rcdr = mapper.readValue(json, RetrieveCountryDataResponse.class);

			return rcdr;

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}

	}
	
	private final String getURL(String countryCode) {
		return RetrieveCountryDataServiceImpl.URL + countryCode;
	}

}
