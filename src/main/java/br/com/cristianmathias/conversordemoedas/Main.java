package br.com.cristianmathias.conversordemoedas;

import br.com.cristianmathias.conversordemoedas.model.CurrencyConverter;
import br.com.cristianmathias.conversordemoedas.sevice.ExchangeRateService;
import br.com.cristianmathias.conversordemoedas.ui.UserInterface;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String apiKey = System.getenv("API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            System.out.println("Variável de ambiente API_KEY não encontrada!");
            return;
        }

        UserInterface ui = new UserInterface();
        ExchangeRateService rateService = new ExchangeRateService(apiKey);
        CurrencyConverter converter = new CurrencyConverter(rateService);

        try {
            String from = ui.askCurrency("Moeda de origem (ex: USD): ");
            String to = ui.askCurrency("Moeda de destino (ex: BRL): ");
            double amount = ui.askAmount("Valor a converter: ");

            double converted = converter.convert(from, to, amount);
            double rate = rateService.getExchangeRate(from, to);

            ui.showResult(from, to, rate, converted);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
