package com.mercadolibre.examen.dto;

import com.mercadolibre.examen.utils.GeolocationUtils;

public class LatLngDTO {
	
	private Double lat;
	
	private Double lng;

	public LatLngDTO(Double lat, Double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}

	public final Double getLat() {
		return lat;
	}

	public final void setLat(Double lat) {
		this.lat = lat;
	}

	public final Double getLng() {
		return lng;
	}

	public final void setLng(Double lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		 return "(" + GeolocationUtils.BUENOS_AIRES_LATLNG.getLat() + "," +  GeolocationUtils.BUENOS_AIRES_LATLNG.getLng() + ") a (" + lat + "," + lng + ")";
	}
	
	

}
