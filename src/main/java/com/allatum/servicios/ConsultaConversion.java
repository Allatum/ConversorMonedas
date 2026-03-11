package com.allatum.servicios;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversion {
    public String buscaConversion(String monedaBase, String monedaObjetivo, double cantidad) {
        try {
            String apiKey = System.getenv("EXCHANGE_RATE_API_KEY");

            if (apiKey == null) {
                throw new RuntimeException("Error: La variable de entorno EXCHANGE_RATE_API_KEY no está configurada.");
            }

            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" +
                    monedaBase + "/" + monedaObjetivo + "/" + cantidad);


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            var json = response.body();
            JsonElement jsonElement = JsonParser.parseString(json);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            return jsonObject.get("conversion_result").getAsString();

        } catch (NumberFormatException | IOException | InterruptedException e) {
            System.out.println("Ocurrio un error: ");
            throw new RuntimeException("Error" + e.getMessage());
        }
    }
}