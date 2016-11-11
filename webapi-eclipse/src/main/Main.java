package main;

import java.io.IOException;

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

	public static void main(String[] args) {
		getKurube();
	}
	
	private static void getKurube() {
		ApiClient apiClient = new ApiClient();
		apiClient.getWeather(LOCATION_CODE_KURUBE, (call, weather) -> {
			System.out.println(weather.toString());
		});
	}
}
