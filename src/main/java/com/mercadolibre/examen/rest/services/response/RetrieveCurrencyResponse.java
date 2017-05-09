package com.mercadolibre.examen.rest.services.response;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * POJO para mappear la respuesta del rest service.
 * 
 * @author Mariano
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetrieveCurrencyResponse implements Response {
	
	@JsonProperty
	private String base;
	
	@JsonProperty
	private String date;
	
	@JsonProperty
	private Map<String, Double> rates = new HashMap<String, Double>();
    
	@JsonAnySetter
    public void set(String fieldName, Double value){
        this.rates.put(fieldName, value);
    }

    public Object get(String fieldName){
        return this.rates.get(fieldName);
    }

	public final Map<String, Double> getRates() {
		return rates;
	}

	public final String getBase() {
		return base;
	}

	public final void setBase(String base) {
		this.base = base;
	}

	public final String getDate() {
		return date;
	}

	public final void setDate(String date) {
		this.date = date;
	}
	
}
