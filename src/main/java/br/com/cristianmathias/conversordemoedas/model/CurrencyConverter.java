package br.com.cristianmathias.conversordemoedas.model;

import br.com.cristianmathias.conversordemoedas.sevice.ExchangeRateService;

import java.io.IOException;

public class CurrencyConverter {
    private final ExchangeRateService exchangeRateService;

    public CurrencyConverter(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    public double convert(String from, String to, double amount) throws IOException, InterruptedException {
        double rate = exchangeRateService.getExchangeRate(from, to);
        return amount * rate;
    }
}
