package main;

import java.io.IOException;

import entity.WeatherEntity;
import network.ApiClient;
import network.ApiClient.ApiClientCallback;
import okhttp3.Call;

/**
 * API ドキュメント
 * http://weather.livedoor.com/weather_hacks/webservice
 */
public class Main {
	
    private static final int LOCATION_CODE_KURUBE = 400040;

	public static void main(String[] args) {
		ApiClient apiClient = new ApiClient();
		apiClient.getWeather(LOCATION_CODE_KURUBE, new ApiClientCallback() {
			@Override
			public void onSuccess(Call call, WeatherEntity weather) {
				System.out.println(weather.toString());
			}
			
			@Override
			public void onFailure(Call call, IOException e) {
			}
		});
	}
}
