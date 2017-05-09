package com.mercadolibre.examen.rest.pojo;

import org.codehaus.jackson.annotate.JsonProperty;

public class Currency {

	@JsonProperty
	private String code;

	@JsonProperty
	private String name;
	
	@JsonProperty
	private String symbol;
	
	public final String getCode() {
		return code;
	}
	
	public final void setCode(String code) {
		this.code = code;
	}
	
	public final String getName() {
		return name;
	}
	
	public final void setName(String name) {
		this.name = name;
	}
	
	public final String getSymbol() {
		return symbol;
	}
	
	public final void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "Currency [code=" + code + "]";
	}
	
	
	
}
