package com.mercadolibre.examen.utils;

import com.mercadolibre.examen.rest.pojo.LatLng;

/**
 * Clase de utilidades para calculo con puntos de geolocalizacion.
 * 
 * @author Mariano
 *
 */
public class GeolocationUtils {
	
	/**
	 * Punto aproximado de la latitud y longitud de Buenos Aires.
	 */
	public static final LatLng BUENOS_AIRES_LATLNG = new LatLng(-34.0,-64.0);
	
	/**
	 * Calcula la distancia de un punto a Buenos Aires
	 * 
	 * @param lat latitud del punto
	 * @param lng longitud del punto
	 * @return la distancia en Kilometros entre los dos puntos.
	 */
	public static double distanceToBuenosAires(double lat, double lng) {
		return distance(BUENOS_AIRES_LATLNG.getLat(), lat, BUENOS_AIRES_LATLNG.getLng(), lng);
	}
	
	/**
	 * Calcula la distancia entre dos puntos latitud y longitud sin tener en cuenta la 
	 * diferencia de altura.
	 * 
	 * @param lat1 la latitud del punto 1.
	 * @param lon1 la longitud del punto 1.
	 * @param lat2 la latitud del punto 2.
	 * @param lon2 la longitud del punto 2.
	 * 
	 * @returns la distancia en Kilometros entre los dos puntos.
	 */
	private static double distance(double lat1, double lat2, double lon1,
	        double lon2) {

	    final int R = 6371;

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(lon2 - lon1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000;

	    distance = Math.pow(distance, 2);

	    return Math.sqrt(distance) / 1000;
	}
}
