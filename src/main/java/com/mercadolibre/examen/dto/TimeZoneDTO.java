package com.mercadolibre.examen.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeZoneDTO {

	private java.util.TimeZone tz;

	public TimeZoneDTO(String tzCode) {
		super();
		String tzId = tzCode.replace("UTC", "GMT");
		tz = java.util.TimeZone.getTimeZone(tzId);
	}
	
	public String getHour() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		sdf.setTimeZone(this.tz);
		return sdf.format(new Date());
	}

	@Override
	public String toString() {
		return getHour() + " (" + tz.getID() + ")";
	}
}
