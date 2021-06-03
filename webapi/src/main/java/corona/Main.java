package corona;

import java.io.IOException;

import com.google.gson.Gson;
import corona.entity.*;
import corona.network.ApiConsts;
import corona.network.OkhttpApiClient;
import corona.network.OkhttpApiClient.ApiClientCallback;
import corona.network.RetrofitApiClient;
import okhttp3.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * API
 * https://data.corona.go.jp/converted-json/covid19japan-all.json
 */
public class Main {
	
	private static Gson gson = new Gson();

	public static void main(String[] args) {
		useOkhttp();
		useRetrofit();
	}

	private static void useOkhttp() {
		OkhttpApiClient okhttpApiClient = new OkhttpApiClient();
		okhttpApiClient.getAll(new ApiClientCallback() {
			@Override
			public void onSuccess(Call call, String json) {
				CovidEntity[] info  = gson.fromJson(json, CovidEntity[].class);

				printResult(info[0]);
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
		retrofitApiClient.getAllJp().enqueue(new Callback<CovidEntity[]>() {
			@Override
			public void onResponse(retrofit2.Call<CovidEntity[]> call, Response<CovidEntity[]> response) {
			    printResult(response.body()[0]);
			}

			@Override
			public void onFailure(retrofit2.Call<CovidEntity[]> call, Throwable t) {
			    t.printStackTrace();
			}
		});
	}

	private static void printResult(CovidEntity info) {
	    for (AreaEntity area: info.areas) {
				System.out.println(area);
			}
	}
}
