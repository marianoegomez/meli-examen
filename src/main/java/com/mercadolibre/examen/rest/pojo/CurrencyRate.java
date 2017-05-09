package com.mercadolibre.examen.rest.pojo;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAnySetter;

public class CurrencyRate {
	
	private Map<String, Double> properties = new HashMap<String, Double>();
    
	@JsonAnySetter
    public void set(String fieldName, Double value){
        this.properties.put(fieldName, value);
    }

    public Object get(String fieldName){
        return this.properties.get(fieldName);
    }

}
