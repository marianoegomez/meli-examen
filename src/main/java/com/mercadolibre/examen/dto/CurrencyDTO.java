package com.mercadolibre.examen.dto;

public class CurrencyDTO {

	private String code;

	private Double rate;

	public CurrencyDTO(String code, Double rate) {
		super();
		this.code = code;
		this.rate = rate;
	}

	public final String getCode() {
		return code;
	}

	public final Double getRate() {
		return rate;
	}

	@Override
	public String toString() {

		if (rate != null) {
			return code + " (1 " + code + " = " + rate + " USD )";
		}
		return code;
	}

}
