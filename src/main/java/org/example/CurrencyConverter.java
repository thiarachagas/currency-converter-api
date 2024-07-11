package org.example;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class CurrencyConverter {

    // Substitua YOUR_API_KEY pela sua chave de API
    private static final String API_KEY = "024076f0b109572054e33967";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/"+API_KEY+"/latest/USD";
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    public void convertUSDTo(String targetCurrency) throws IOException, InterruptedException {
        JsonObject rates = getRates();

        if (rates != null) {
            JsonElement targetRate = rates.getAsJsonObject("conversion_rates").get(targetCurrency);
            if (targetRate != null) {
                double rate = targetRate.getAsDouble();
                System.out.printf("1 USD = %.2f %s\n", rate, targetCurrency);
            } else {
                System.out.printf("Taxa de conversão para %s não encontrada.\n", targetCurrency);
            }
        } else {
            throw new IOException("Erro ao obter as taxas de câmbio.");
        }
    }

    public void showAllRates() throws IOException, InterruptedException {
        JsonObject rates = getRates();

        if (rates != null) {
            System.out.println("Taxas de câmbio disponíveis:");
            JsonObject ratesObj = rates.getAsJsonObject("conversion_rates");
            for (String currency : ratesObj.keySet()) {
                double rate = ratesObj.get(currency).getAsDouble();
                System.out.printf("%s: %.2f\n", currency, rate);
            }
        } else {
            throw new IOException("Erro ao obter as taxas de câmbio.");
        }
    }

    public void showSpecificRates(List<String> currencies) throws IOException, InterruptedException {
        JsonObject rates = getRates();

        if (rates != null) {
            System.out.println("Taxas de câmbio específicas:");
            JsonObject ratesObj = rates.getAsJsonObject("conversion_rates");
            for (String currency : currencies) {
                JsonElement rateElement = ratesObj.get(currency);
                if (rateElement != null) {
                    double rate = rateElement.getAsDouble();
                    System.out.printf("%s: %.2f\n", currency, rate);
                } else {
                    System.out.printf("%s: Não disponível\n", currency);
                }
            }
        } else {
            throw new IOException("Erro ao obter as taxas de câmbio.");
        }
    }

    private JsonObject getRates() throws IOException, InterruptedException {
        System.out.println("Enviando requisição para a API: " + API_URL);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status da resposta: " + response.statusCode());
        if (response.statusCode() == 200) {
            String jsonResponse = response.body();
            System.out.println("Resposta JSON recebida: " + jsonResponse);
            return gson.fromJson(jsonResponse, JsonObject.class);
        } else {
            System.out.println("Erro na requisição: " + response.body());
            return null;
        }
    }
}
























































/*import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConverter {

    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/USD";
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    public void convertUSDTo(String targetCurrency) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String jsonResponse = response.body();
            JsonObject rates = gson.fromJson(jsonResponse, JsonObject.class);

            double rate = rates.getAsJsonObject("rates").get(targetCurrency).getAsDouble();
            System.out.printf("1 USD = %.2f %s\n", rate, targetCurrency);
        } else {
            throw new IOException("Erro ao obter as taxas de câmbio: " + response.statusCode());
        }
    }

    public void showAllRates() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String jsonResponse = response.body();
            JsonObject rates = gson.fromJson(jsonResponse, JsonObject.class);

            System.out.println("Taxas de câmbio disponíveis:");
            JsonObject ratesObj = rates.getAsJsonObject("rates");
            for (String currency : ratesObj.keySet()) {
                double rate = ratesObj.get(currency).getAsDouble();
                System.out.printf("%s: %.2f\n", currency, rate);
            }
        } else {
            throw new IOException("Erro ao obter as taxas de câmbio: " + response.statusCode());
        }
    }
}
*/