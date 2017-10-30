import java.io.IOException;

import com.google.gson.Gson;
import entity.ForecastEntity;
import entity.WeatherEntity;
import network.ApiConsts;
import network.OkhttpApiClient;
import network.OkhttpApiClient.ApiClientCallback;
import network.RetrofitApiClient;
import okhttp3.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
		useOkhttp();
		useRetrofit();
	}

	private static void useOkhttp() {
		OkhttpApiClient okhttpApiClient = new OkhttpApiClient();
		okhttpApiClient.getWeather(LOCATION_CODE_KURUBE, new ApiClientCallback() {
			@Override
			public void onSuccess(Call call, String json) {
				WeatherEntity weather = gson.fromJson(json, WeatherEntity.class);
				printResult(weather);
			}

			@Override
			public void onFailure(Call call, IOException e) {
				e.printStackTrace();
			}
		});
	}

	private static void useRetrofit() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(ApiConsts.SCHEME + "://" + ApiConsts.HOST)
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		RetrofitApiClient retrofitApiClient = retrofit.create(RetrofitApiClient.class);
		retrofitApiClient.getWeather(LOCATION_CODE_KURUBE).enqueue(new Callback<WeatherEntity>() {
			@Override
			public void onResponse(retrofit2.Call<WeatherEntity> call, Response<WeatherEntity> response) {
			    printResult(response.body());
			}

			@Override
			public void onFailure(retrofit2.Call<WeatherEntity> call, Throwable t) {
			    t.printStackTrace();
			}
		});
	}

	private static void printResult(WeatherEntity weather) {
		ForecastEntity forecast = weather.getForecasts().get(1);

		System.out.print(forecast.getDate() + "の天気: ");
		System.out.println(forecast.getTelop());
	}
}
