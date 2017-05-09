package com.mercadolibre.examen.rest.pojo;

public class LatLng {
	
	private Double lat;
	
	private Double lng;

	public LatLng(Double lat, Double lng) {
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

}
