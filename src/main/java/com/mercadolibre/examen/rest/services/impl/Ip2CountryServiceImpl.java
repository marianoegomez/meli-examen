package com.mercadolibre.examen.rest.services.impl;

import org.codehaus.jackson.map.ObjectMapper;
import com.mercadolibre.examen.rest.services.BaseRestService;
import com.mercadolibre.examen.rest.services.exceptions.ServiceException;
import com.mercadolibre.examen.rest.services.request.Ip2CountryRequest;
import com.mercadolibre.examen.rest.services.request.Request;
import com.mercadolibre.examen.rest.services.response.Ip2CountryResponse;
import com.mercadolibre.examen.rest.services.response.Response;
import com.sun.jersey.api.client.ClientResponse;

/**
 * Clase que implementa la invocacion especifica del servicio ip2country
 * 
 * @author Mariano
 */
public class Ip2CountryServiceImpl extends BaseRestService {
	
	private static final String URL = "https://api.ip2country.info/ip?";

	public Response send(Request request) throws ServiceException {

		try {
			ClientResponse response = createRequest(this.getURL(((Ip2CountryRequest)request).getIp()));
			String json = response.getEntity(String.class);
			ObjectMapper mapper = new ObjectMapper();
			Ip2CountryResponse ip2cr = mapper.readValue(json, Ip2CountryResponse.class);

			return ip2cr;

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
	
	private final String getURL(String ip) {
		return Ip2CountryServiceImpl.URL + ip;
	}

}
