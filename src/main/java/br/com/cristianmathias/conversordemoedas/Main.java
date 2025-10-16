package br.com.cristianmathias.conversordemoedas;

import br.com.cristianmathias.conversordemoedas.model.CurrencyConverter;
import br.com.cristianmathias.conversordemoedas.sevice.ExchangeRateService;
import br.com.cristianmathias.conversordemoedas.ui.UserInterface;
import java.io.IOException;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n=== Conversor de Moedas ===");
            System.out.println("1 - Dólar → Peso Argentino");
            System.out.println("2 - Peso Argentino → Dólar");
            System.out.println("3 - Dólar → Real Brasileiro");
            System.out.println("4 - Real Brasileiro → Dólar");
            System.out.println("5 - Dólar → Peso Colombiano");
            System.out.println("6 - Peso Colombiano → Dólar");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção válida: ");

            while (!scanner.hasNextInt()){
                System.out.println("Entrada inválida! Digite um número entre 1 e 7.");
                System.out.print("Escolha uma opção válida: ");
                scanner.next();
            }
            option = scanner.nextInt();

            if (option >= 1 && option <= 6) {
                System.out.print("Digite o valor a converter: ");
                double amount = 0;
                boolean validInput = false;

                // loop para garantir entrada válida do valor
                while (!validInput) {
                    System.out.print("Digite o valor a converter: ");
                    String input = scanner.next().replace(",", ".");

                    try {
                        amount = Double.parseDouble(input);
                        validInput = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido!");
                    }
                }

                String fromCurrency = "";
                String toCurrency = "";

                switch (option) {
                    case 1 -> { fromCurrency = "USD"; toCurrency = "ARS"; }
                    case 2 -> { fromCurrency = "ARS"; toCurrency = "USD"; }
                    case 3 -> { fromCurrency = "USD"; toCurrency = "BRL"; }
                    case 4 -> { fromCurrency = "BRL"; toCurrency = "USD"; }
                    case 5 -> { fromCurrency = "USD"; toCurrency = "COP"; }
                    case 6 -> { fromCurrency = "COP"; toCurrency = "USD"; }
                }

                try {
                    double convertedValue = converter.convert(fromCurrency, toCurrency, amount);
                    double rate = rateService.getExchangeRate(fromCurrency, toCurrency);
                    ui.showResult(fromCurrency, toCurrency, rate, convertedValue);
                } catch (IOException | InterruptedException e) {
                    System.out.println("Erro ao consultar a API.");
                    e.printStackTrace();
                }
            } else if (option != 7) {
                System.out.println("Opção inválida!");
            }

        } while (option != 7);

        System.out.println("Programa encerrado.");
        scanner.close();
    }
}
