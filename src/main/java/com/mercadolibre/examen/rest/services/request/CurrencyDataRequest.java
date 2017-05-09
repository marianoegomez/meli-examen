package com.mercadolibre.examen.rest.services.request;

import com.mercadolibre.examen.rest.pojo.Currency;

public class CurrencyDataRequest implements Request{
	
	private Currency currency;
	
	public CurrencyDataRequest(Currency currency) {
		super();
		this.currency = currency;
	}

	public final Currency getCurrency() {
		return currency;
	}

	public final void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
