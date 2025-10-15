package br.com.cristianmathias.conversordemoedas.sevice;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateService {
    private final String apiKey;

    public ExchangeRateService(String apiKey) {
        this.apiKey = apiKey;
    }

    public double getExchangeRate(String from, String to) throws IOException, InterruptedException {
        String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + from + "/" + to;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlStr))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject jsonObj = JsonParser.parseString(response.body()).getAsJsonObject();
        return jsonObj.get("conversion_rate").getAsDouble();
    }
}
