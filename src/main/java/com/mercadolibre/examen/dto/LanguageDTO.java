package com.mercadolibre.examen.dto;

public class LanguageDTO {

	private String isoCode6391;

	private String name;

	public LanguageDTO(String isoCode6391, String name) {
		super();
		this.isoCode6391 = isoCode6391;
		this.name = name;
	}

	public final String getIsoCode6391() {
		return isoCode6391;
	}

	public final String getName() {
		return name;
	}

	public final void setIsoCode6391(String isoCode6391) {
		this.isoCode6391 = isoCode6391;
	}

	public final void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + "(" + isoCode6391 + ")";
	}
}