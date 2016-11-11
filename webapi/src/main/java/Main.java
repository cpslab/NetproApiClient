import com.google.gson.Gson;
import okhttp3.Call;
import webapi.model.Weather;
import webapi.network.ApiClient;

import java.io.IOException;

public class Main {

    private static final int LOCATION_CODE_TOKYO = 130010;

    public static void main(String[] args) {
        printWeather();
    }

    private static void printWeather() {
        ApiClient apiClient = new ApiClient();
        apiClient.getWeather(LOCATION_CODE_TOKYO, new ApiClient.ApiClientCallback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onSuccess(Call call, Weather weather) {
                System.out.println(weather.toString());
            }
        });

        apiClient.getWeather(LOCATION_CODE_TOKYO, (call, e) -> {}, (call, weather) -> {});
    }
}
