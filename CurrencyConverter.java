import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyConverter {
    private static String[] args;

    public static void main(String[] args) {
        CurrencyConverter.args = args;
        double amount = 100;
        String fromCurrency = "USD";
        String toCurrency = "EUR";
        double exchangeRate = getExchangeRate(fromCurrency, toCurrency);
        double convertedAmount = amount * exchangeRate;
        System.out.println(amount + " " + fromCurrency + " is equal to " + convertedAmount + " " + toCurrency);
    }

    private static double getExchangeRate(String fromCurrency, String toCurrency) {
        try {
            URL url = new URL("https://api.exchangeratesapi.io/latest?base=" + fromCurrency + "&symbols=" + toCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                JSONObject exchangeRates = new JSONObject(response.toString());
                JSONObject rates = exchangeRates.getJSONObject("rates");
                return rates.getDouble(toCurrency);
            } else {
                System.out.println("Failed to retrieve exchange rate data. Response code: " + responseCode);
                return -1;
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            return -1;
        }
    }
}
