package com.mercadolibre.examen.utils;

/**
 * Clase utilitaria para acceso a cache
 * 
 * @author Mariano
 *
 */
public class CacheUtils {

	/**
	 * Genera la key de cache para la fecha actual.
	 * @return
	 */
	public static String getCurrencyCacheKey() {
		return DateUtils.getCurrentDate("yyyy-MM-dd");
	}

}
