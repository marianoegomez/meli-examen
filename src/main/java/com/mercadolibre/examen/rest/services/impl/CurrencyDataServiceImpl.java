package com.mercadolibre.examen.rest.services.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;

import com.mercadolibre.examen.rest.services.BaseRestService;
import com.mercadolibre.examen.rest.services.exceptions.ServiceException;
import com.mercadolibre.examen.rest.services.request.CurrencyDataRequest;
import com.mercadolibre.examen.rest.services.request.Request;
import com.mercadolibre.examen.rest.services.response.Response;
import com.mercadolibre.examen.rest.services.response.RetrieveCurrencyResponse;
import com.mercadolibre.examen.utils.CacheUtils;
import com.sun.jersey.api.client.ClientResponse;

/**
 * Clase que implementa la invocacion especifica del servicio fixer
 * 
 * @author Mariano
 */
public class CurrencyDataServiceImpl extends BaseRestService {
	
	/**
	 * Representa un cache muy simple para evitar hacer llamadas innecesarias ya que la informacion se actualiza cada dia.
	 * Utiliza como key la fecha de actualizacion.
	 */
	private final Map<String, RetrieveCurrencyResponse> cache;
	
	/**
	 * Define el conjunto de currencies soportadas por el servicio. Si una carrency no es soportada, directamente no se invoca al rest.
	 */
	private static final Set<String> suportedCurrencies;
	
	static {
		suportedCurrencies = new HashSet<String>();
		suportedCurrencies.add("AUD");
		suportedCurrencies.add("BGN");
		suportedCurrencies.add("BRL");
	    suportedCurrencies.add("CAD");
		suportedCurrencies.add("CHF");
		suportedCurrencies.add("CNY");
		suportedCurrencies.add("CZK");
		suportedCurrencies.add("DKK");
		suportedCurrencies.add("GBP");
		suportedCurrencies.add("HKD");
		suportedCurrencies.add("HRK");
		suportedCurrencies.add("HUF");
		suportedCurrencies.add("IDR");
		suportedCurrencies.add("ILS");
		suportedCurrencies.add("INR");
		suportedCurrencies.add("JPY");
		suportedCurrencies.add("KRW");
		suportedCurrencies.add("MXN");
		suportedCurrencies.add("MYR");
		suportedCurrencies.add("NOK");
		suportedCurrencies.add("NZD");
		suportedCurrencies.add("PHP");
		suportedCurrencies.add("PLN");
		suportedCurrencies.add("RON");
		suportedCurrencies.add("RUB");
		suportedCurrencies.add("SEK");
		suportedCurrencies.add("SGD");
		suportedCurrencies.add("THB");
		suportedCurrencies.add("TRY");
		suportedCurrencies.add("ZAR");
		suportedCurrencies.add("EUR");
	}
	
	/**
	 * Constructor.
	 */
	public CurrencyDataServiceImpl() {
		super();
		this.cache = new HashMap<String, RetrieveCurrencyResponse>();
	}

	/** 
	 * Obtiene los rates usando como base la currency que viene en el request.
	 * Solo ejecuta el llamado al servicio si la currency es soportada  y si no esta presente en cache.
	 * @throws ServiceException 
	 * 
	 * @see com.mercadolibre.examen.rest.services.Service#send(com.mercadolibre.examen.rest.services.request.Request)
	 */
	public Response send(Request request) throws ServiceException {
		
		RetrieveCurrencyResponse rcr = new RetrieveCurrencyResponse();
		
		String currencyCode = ((CurrencyDataRequest)request).getCurrency().getCode();
		if (suportedCurrencies.contains(currencyCode)) { 
		
			String key = CacheUtils.getCurrencyCacheKey();
			rcr = cache.get(key);
			if (rcr == null) {
				try {
					ClientResponse response = createRequest("http://api.fixer.io/latest?base=" + currencyCode);
					
					String json = response.getEntity(String.class);
					ObjectMapper mapper = new ObjectMapper();
					rcr = mapper.readValue(json, RetrieveCurrencyResponse.class);
				} catch (Exception e) {
					e.printStackTrace();
					throw new ServiceException(e.getMessage());
				}
				cache.put(key, (RetrieveCurrencyResponse)rcr);
			}
		}
		return rcr;
	}
}
