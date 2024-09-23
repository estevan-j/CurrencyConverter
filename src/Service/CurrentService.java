package Service;

import Models.Currency;
import Models.CurrencyModel;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrentService {
    public CurrencyModel getCurrencyDivisas(String base) throws IOException, InterruptedException {
        String uri = "https://v6.exchangerate-api.com/v6/d14e94d20040ddf4410535e5/latest/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri + base))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        Currency cash = gson.fromJson(response.body(), Currency.class);
        return new CurrencyModel(cash.base_code(), cash.conversion_rates());
    }
}
