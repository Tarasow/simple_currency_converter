import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ServerConnection {
    public String getData(String[] currency) throws Exception {
        String urlString = "http://api.fixer.io/latest?base=" +
                currency[0] + "&symbols=" + currency[1];
        URL source = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) source.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer response = new StringBuffer();
        String stringLine;
        while ((stringLine = reader.readLine()) != null) {
            response.append(stringLine);
        }
        reader.close();

        stringLine = response.toString();
        new Cache().addToCache(currency, stringLine);

        return stringLine;
    }
}