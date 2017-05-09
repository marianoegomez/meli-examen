package com.mercadolibre.examen.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mercadolibre.examen.dto.CurrencyDTO;
import com.mercadolibre.examen.dto.LanguageDTO;
import com.mercadolibre.examen.dto.LatLngDTO;
import com.mercadolibre.examen.dto.TimeZoneDTO;
import com.mercadolibre.examen.rest.pojo.Currency;
import com.mercadolibre.examen.rest.pojo.Language;
import com.mercadolibre.examen.rest.services.Service;
import com.mercadolibre.examen.rest.services.exceptions.ServiceException;
import com.mercadolibre.examen.rest.services.exceptions.UnavailableCountryDataException;
import com.mercadolibre.examen.rest.services.impl.CurrencyDataServiceImpl;
import com.mercadolibre.examen.rest.services.impl.Ip2CountryServiceImpl;
import com.mercadolibre.examen.rest.services.impl.RetrieveCountryDataServiceImpl;
import com.mercadolibre.examen.rest.services.request.CurrencyDataRequest;
import com.mercadolibre.examen.rest.services.request.Ip2CountryRequest;
import com.mercadolibre.examen.rest.services.request.RetrieveCountryDataRequest;
import com.mercadolibre.examen.rest.services.response.Ip2CountryResponse;
import com.mercadolibre.examen.rest.services.response.RetrieveCountryDataResponse;
import com.mercadolibre.examen.rest.services.response.RetrieveCurrencyResponse;
import com.mercadolibre.examen.utils.DateUtils;
import com.mercadolibre.examen.utils.GeolocationUtils;

/**
 * Clase que controla la invocacion a los diferentes servicios rest
 * para obtener la informacion del pais y generar la respuesta.
 * 
 * Utiliza el servicio ip2country para obtener el countryCode a partir de la IP.
 * Utiliza el servicio restCountries para obtener la informacion restante.
 * Utiliza el servicio fixer para obtener y calcular la cotiacion en USD de las monedas.
 * 
 * @author Mariano
 *
 */
public class TraceIpCommand {
	
	private Service ip2CountryService;
	
	private Service retriveCountryDataService;
	
	private Service currencyDataService;
	
	public TraceIpCommand() {
		super();
		this.ip2CountryService = new Ip2CountryServiceImpl();
		this.retriveCountryDataService = new RetrieveCountryDataServiceImpl();
		this.currencyDataService = new CurrencyDataServiceImpl();
	}

	/**
	 * Controla la ejecuccion del comando, utilizando los servicios rest y
	 * generando la respuesta a partir de los mismos. 
	 * 
	 * @param ip la direccion ip
	 * @return TraceIpResult que es populado con la info necesaria.
	 * @throws UnavailableCountryDataException si no hay informacion disponible sobre la IP
	 */
	public TraceIpResult execute(String ip) throws UnavailableCountryDataException {
		
		TraceIpResult result = new TraceIpResult();
		
		try {
			Ip2CountryResponse ip2cr = (Ip2CountryResponse)this.ip2CountryService.send(new Ip2CountryRequest(ip));
			
			if (ip2cr.getCountryCode().equals("")) {
				throw new UnavailableCountryDataException();
			}
			
			RetrieveCountryDataResponse rcdr = (RetrieveCountryDataResponse)this.retriveCountryDataService.send(new RetrieveCountryDataRequest(ip2cr.getCountryCode()));

			populateResult(ip, result, ip2cr, rcdr);
		} catch (ServiceException e) {
			System.out.println("Services error");
		}
		
		return result;
	}

	private void populateResult(String ip, TraceIpResult result, Ip2CountryResponse ip2cr,
			RetrieveCountryDataResponse rcdr) throws ServiceException {
		result.setIp(ip);
		result.setCurrentDate(DateUtils.getCurrentDate());
		result.setName(ip2cr.getCountryName());
		result.setNativeName(rcdr.getNativeName());
		result.setIsoCode(ip2cr.getCountryCode());
		
		LatLngDTO latLng = new LatLngDTO(rcdr.getLatLng().get(0),rcdr.getLatLng().get(1));
		result.setLatLng(latLng);
		result.setDistance(GeolocationUtils.distanceToBuenosAires(latLng.getLat(), latLng.getLng()));
		
		List<LanguageDTO> languages = new ArrayList<LanguageDTO>();
		for (Language language : rcdr.getLanguages()) {
			LanguageDTO languageDTO = new LanguageDTO(language.getIsoCode6391(), language.getName());
			languages.add(languageDTO);
		}
		result.setLanguages(languages);
		
		List<TimeZoneDTO> timeZones = new ArrayList<TimeZoneDTO>();
		for (String item : rcdr.getTimezones()) {
			TimeZoneDTO tz = new TimeZoneDTO(item);
			timeZones.add(tz);
		}
		result.setTimezones(timeZones);
		
		List<CurrencyDTO> currencyRates = new ArrayList<CurrencyDTO>();
		for (Currency currency : rcdr.getCurrencies()) {
			RetrieveCurrencyResponse rcr = (RetrieveCurrencyResponse)this.currencyDataService.send(new CurrencyDataRequest(currency));
			Map<String, Double> rates = rcr.getRates();
			CurrencyDTO currencyRate = new CurrencyDTO (currency.getCode(), rates.get("USD"));
			currencyRates.add(currencyRate);
		}
		result.setCurrencies(currencyRates);
	}
}
