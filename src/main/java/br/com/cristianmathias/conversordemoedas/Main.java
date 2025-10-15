package br.com.cristianmathias.conversordemoedas;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            String apiKey = System.getenv("API_KEY");
            if (apiKey == null || apiKey.isEmpty()) {
                System.out.println("Variável de ambiente API_KEY não encontrada!");
                return;
            }

            Scanner sc = new Scanner(System.in);
            System.out.print("Moeda de origem (ex: USD): ");
            String moedaOrigem = sc.next().toUpperCase();
            System.out.print("Moeda de destino (ex: BRL): ");
            String moedaDestino = sc.next().toUpperCase();
            System.out.print("Valor a converter: ");
            double valor = sc.nextDouble();

            String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/"
                    + moedaOrigem + "/" + moedaDestino;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlStr))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObj = JsonParser.parseString(response.body()).getAsJsonObject();
            double taxa = jsonObj.get("conversion_rate").getAsDouble();
            double valorConvertido = valor * taxa;

            System.out.printf("Taxa %s → %s: %.4f%n", moedaOrigem, moedaDestino, taxa);
            System.out.printf("Valor convertido: %.2f %s%n", valorConvertido, moedaDestino);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
