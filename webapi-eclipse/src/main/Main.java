package main;

import java.io.IOException;

import entity.WeatherEntity;
import network.ApiClient;
import network.ApiClient.ApiClientCallback;
import okhttp3.Call;

public class Main {

	public static void main(String[] args) {
		ApiClient apiClient = new ApiClient();
		apiClient.getWeather(130010, new ApiClientCallback() {
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
