package com.mercadolibre.examen.rest.services.response;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.mercadolibre.examen.rest.pojo.Currency;
import com.mercadolibre.examen.rest.pojo.Language;

/**
 * POJO para mappear la respuesta del rest service.
 * 
 * @author Mariano
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetrieveCountryDataResponse implements Response{

	private String nativeName;
	
	@JsonProperty("latlng")
	private List<Double> latLng = new ArrayList<Double>();

	private List<Language> languages = new ArrayList<Language>();
	
	private List<String> timezones = new ArrayList<String>();
	
	private List<Currency> currencies = new ArrayList<Currency>();

	public final List<Double> getLatLng() {
		return latLng;
	}

	public final String getNativeName() {
		return nativeName;
	}

	public final void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}

	public final void setLatLng(List<Double> latLng) {
		this.latLng = latLng;
	}

	public final List<Language> getLanguages() {
		return languages;
	}

	public final void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public final List<String> getTimezones() {
		return timezones;
	}

	public final void setTimezones(List<String > timezones) {
		this.timezones = timezones;
	}

	public final List<Currency> getCurrencies() {
		return currencies;
	}

	public final void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}
}
