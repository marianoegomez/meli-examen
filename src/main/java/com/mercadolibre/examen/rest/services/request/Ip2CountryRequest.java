package com.mercadolibre.examen.rest.services.request;

public class Ip2CountryRequest implements Request {
	
	private String ip;

	public Ip2CountryRequest(String ip) {
		super();
		this.ip = ip;
	}

	public final String getIp() {
		return ip;
	}

	public final void setIp(String ip) {
		this.ip = ip;
	}

}
