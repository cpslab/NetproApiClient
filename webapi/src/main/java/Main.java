import okhttp3.Call;
import webapi.entity.WeatherEntity;
import webapi.network.ApiClient;

import java.io.IOException;

public class Main {

    private static final int LOCATION_CODE_TOKYO = 400040;

    /**
     * API ドキュメント
     * http://weather.livedoor.com/weather_hacks/webservice
     *
     * 東京のロケーションコードは130010
     */
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        apiClient.getWeather(LOCATION_CODE_TOKYO, new ApiClient.ApiClientCallback() {
            @Override
            public void onSuccess(Call call, WeatherEntity weather) {
                System.out.println(weather.toString());
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
        });
    }
}
