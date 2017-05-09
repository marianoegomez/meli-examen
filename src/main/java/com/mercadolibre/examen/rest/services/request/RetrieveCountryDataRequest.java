package com.mercadolibre.examen.rest.services.request;

public class RetrieveCountryDataRequest implements Request{
	
	private String countryCode;
	
	public RetrieveCountryDataRequest(String countryCode) {
		super();
		this.countryCode = countryCode;
	}

	public final String getCountryCode() {
		return countryCode;
	}

	public final void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
