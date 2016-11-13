package main;

import java.io.IOException;

import com.google.gson.Gson;
import entity.LocationEntity;
import entity.WeatherEntity;
import network.ApiClient;
import network.ApiClient.ApiClientCallback;
import okhttp3.Call;

/**
 * API ドキュメント
 * http://weather.livedoor.com/weather_hacks/webservice
 *
 * 東京のロケーションコードは400040
 */
public class Main {
	
    private static final int LOCATION_CODE_KURUBE = 400040;

	private static Gson gson = new Gson();

	public static void main(String[] args) {
		ApiClient apiClient = new ApiClient();
        apiClient.getWeather(LOCATION_CODE_KURUBE, new ApiClientCallback() {
			@Override
			public void onSuccess(Call call, String json) {
                WeatherEntity weather = gson.fromJson(json, WeatherEntity.class);

				System.out.println(weather.toString());

				System.out.print(weather.getForecasts().get(1).getDate() + "の天気: ");
				System.out.println(weather.getForecasts().get(1).getTelop());

				LocationEntity location = weather.getLocation();
				System.out.print(location.getArea() + location.getPref() + location.getCity());
			}

			@Override
			public void onFailure(Call call, IOException e) {
				e.printStackTrace();
			}
		});

	}
}
