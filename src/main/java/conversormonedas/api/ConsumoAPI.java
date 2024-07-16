package conversormonedas.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsumoAPI {

    public Map<String, Double> obtenerValores(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        Gson gson = new Gson();
        Map<String, Object> responseMap = gson.fromJson(json, new TypeToken<Map<String, Object>>() {}.getType());
        Map<String, Double> conversionRates = (Map<String, Double>) responseMap.get("conversion_rates");
        return conversionRates;
    }
}

