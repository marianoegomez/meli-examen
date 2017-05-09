package com.mercadolibre.examen.rest.services.response;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * POJO para mappear la respuesta del rest service.
 * 
 * @author Mariano
 *
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ip2CountryResponse implements Response {

	@JsonProperty
	private String countryCode;
	
	@JsonProperty
	private String countryCode3;

	@JsonProperty
	private String countryName;
	
	@JsonProperty
	private String countryEmoji;
	
	public Ip2CountryResponse() {
		super();
		this.countryCode = null;
		this.countryCode3 = null;
		this.countryName = null;
		this.countryEmoji = null;
	}	
	
	public final void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public final void setCountryCode3(String countryCode3) {
		this.countryCode3 = countryCode3;
	}

	public final void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getCountryCode3() {
		return countryCode3;
	}

	public String getCountryName() {
		return countryName;
	}

	public final String getCountryEmoji() {
		return countryEmoji;
	}

	public final void setCountryEmoji(String countryEmoji) {
		this.countryEmoji = countryEmoji;
	}
	
}
