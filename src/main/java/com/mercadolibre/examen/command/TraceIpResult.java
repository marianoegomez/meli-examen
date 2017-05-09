package com.mercadolibre.examen.command;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.mercadolibre.examen.dto.CurrencyDTO;
import com.mercadolibre.examen.dto.LanguageDTO;
import com.mercadolibre.examen.dto.LatLngDTO;
import com.mercadolibre.examen.dto.TimeZoneDTO;

/**
 * Representa la respuesta del comando para tracear una IP
 * 
 * @author Mariano
 *
 */
public class TraceIpResult {
	
	private String ip;

	private String currentDate;
	
	private String name;
	
	private String nativeName;
	
	private String isoCode;
	
	private LatLngDTO latLng;
	
	private double distance;
	
	private List<LanguageDTO> languages = new ArrayList<LanguageDTO>();
	
	private List<CurrencyDTO> currencies = new ArrayList<CurrencyDTO>();
	
	private List<TimeZoneDTO> timezones = new ArrayList<TimeZoneDTO>();
	
	public final String getIp() {
		return ip;
	}

	public final void setIp(String ip) {
		this.ip = ip;
	}

	public final void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public final String getCurrentDate() {
		return currentDate;
	}

	public final String getName() {
		return name;
	}
	
	public final void setName(String name) {
		this.name = name;
	}
	
	public final String getNativeName() {
		return nativeName;
	}
	
	public final void setNativeName(String nativeName) {
		this.nativeName = nativeName;
	}
	
	public final String getIsoCode() {
		return isoCode;
	}
	
	public final void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public final LatLngDTO getLatLng() {
		return latLng;
	}

	public final void setLatLng(LatLngDTO latLng) {
		this.latLng = latLng;
	}

	public final double getDistance() {
		return distance;
	}
	
	public final String getFormattedDistance() {
		NumberFormat formatter = new DecimalFormat("#0.00");
		return formatter.format(this.distance);
	}

	public final void setDistance(double distance) {
		this.distance = distance;
	}

	public final List<LanguageDTO> getLanguages() {
		return languages;
	}

	public final void setLanguages(List<LanguageDTO> languages) {
		this.languages = languages;
	}

	public final List<CurrencyDTO> getCurrencies() {
		return currencies;
	}

	public final void setCurrencies(List<CurrencyDTO> currencies) {
		this.currencies = currencies;
	}

	public final List<TimeZoneDTO> getTimezones() {
		return timezones;
	}

	public final void setTimezones(List<TimeZoneDTO> timezones) {
		this.timezones = timezones;
	}

	@Override
	public String toString() {
		
		return "IP: " + this.ip 
			+ "\n" + "Fecha actual: " + this.getCurrentDate() 
			+ "\n" + "Pais: " + this.getNativeName() + " (" + name + ")" 
			+ "\n" + "ISO Code: " + isoCode 
			+ "\n" + "Idiomas: " + languages.toString() 
			+ "\n" + "Moneda: " + currencies.toString() 
			+ "\n" + "Hora: " + timezones.toString() 
			+ "\n" + "Distancia estimada: " + this.getFormattedDistance() +" Km. " + this.getLatLng().toString();
	}

}
