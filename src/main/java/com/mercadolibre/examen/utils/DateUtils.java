package com.mercadolibre.examen.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase de utilidades para calculo con fechas.
 * 
 * @author Mariano
 *
 */
public class DateUtils {
	
	
	/**
	 * Aplica formato dd/MM/yyyy hh:mm:ss a la fecha actual.
	 * 
	 * @return la fecha en formato dd/MM/yyyy hh:mm:ss
	 */
	public static String getCurrentDate() {
		return getCurrentDate("dd/MM/yyyy hh:mm:ss");
	}
	
	/**
	 * Aplica el formato pasado por parametro a la fecha actual.
	 * 
	 * @param format el formato
	 * @return la fecha en el formato correspondiente
	 */
	public static String getCurrentDate(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
}
