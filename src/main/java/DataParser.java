import com.google.gson.*;

public class DataParser {
    public String getAnswer(String[] currency) throws Exception {
        Cache localStorage = new Cache();
        ApiResponse response = localStorage.isInCache(currency)
                ? localStorage.getFromCache(currency)
                : getResponseObject(new ServerConnection().getData(currency));
        return response.getBase() + " => " + response.getTo() + " : " + response.getRate();
    }

    public ApiResponse getResponseObject(String json) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(RateObject.class, new RatesDeserializer())
                .create();
        return gson.fromJson(json, ApiResponse.class);
    }
}