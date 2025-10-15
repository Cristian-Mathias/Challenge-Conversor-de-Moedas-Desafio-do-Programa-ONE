package br.com.cristianmathias.conversordemoedas;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try {
            String apiKey = System.getenv("API_KEY");
            String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.setRequestMethod("GET");

            InputStream inputStream = request.getInputStream();
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader(inputStream));
            JsonObject jsonobj = root.getAsJsonObject();

            String req_result = jsonobj.get("result").getAsString();
            System.out.println("Resultado da requisição: " + req_result);

            double taxaUsdToBrl = jsonobj.getAsJsonObject("conversion_rates").get("BRL").getAsDouble();
            System.out.println("Taxa USD → BRL: " + taxaUsdToBrl);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
