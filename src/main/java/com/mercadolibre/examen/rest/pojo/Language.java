package com.mercadolibre.examen.rest.pojo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Language {
	
	@JsonProperty("iso639_1")
	private String isoCode6391;
	
	@JsonProperty()
	private String name;

	public final String getIsoCode6391() {
		return isoCode6391;
	}

	public final void setIsoCode6391(String isoCode6391) {
		this.isoCode6391 = isoCode6391;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

}
