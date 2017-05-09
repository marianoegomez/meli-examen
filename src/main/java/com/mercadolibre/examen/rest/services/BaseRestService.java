package com.mercadolibre.examen.rest.services;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * Clase que encapsula el comportamiento comun de la invocacion a los servicios
 * 
 * @author Mariano
 *
 */
public abstract class BaseRestService implements Service {
	
	/**
	 * Ejecuta el servicio rest
	 * 
	 * @param url la URL del rest service
	 * @return ClientResponse
	 */
	public ClientResponse createRequest(String url){
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);

		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		
		return response;
	}

	
}
