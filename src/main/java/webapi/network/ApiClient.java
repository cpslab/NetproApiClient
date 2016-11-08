package webapi.network;

import com.google.gson.Gson;
import okhttp3.*;
import webapi.entity.WeatherEntity;
import webapi.model.Weather;

import java.io.IOException;

public class ApiClient {

    public static final String TAG = "DEBUG: " + ApiClient.class.getSimpleName() + ": ";

    private OkHttpClient client = new OkHttpClient();

    private Request request;

    private Gson gson = new Gson();

    /**
     * locationCodeは↓を参照
     * http://weather.livedoor.com/forecast/rss/primary_area.xml
     *
     * @param locationCode
     */
    public void getWeather(int locationCode, ApiClientCallback apiClientCallback) {
        HttpUrl.Builder builder = UrlBuilder.buildUrl();
        builder.addQueryParameter("city", String.valueOf(locationCode));
        enqueue(builder, apiClientCallback);
    }

    private void enqueue(HttpUrl.Builder builder, ApiClientCallback apiClientCallback) {
        request = new Request.Builder()
                .url(builder.build())
                .get().build();

        System.out.println(TAG + "enqueue: " + request.url().toString());

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                apiClientCallback.onFailure(call, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                System.out.println(TAG + "response" + result);
                apiClientCallback.onSuccess(call,
                        Weather.entityToModel(gson.fromJson(result, WeatherEntity.class)));
            }
        });
    }

    public interface ApiClientCallback {

        void onFailure(Call call, IOException e);

        void onSuccess(Call call, Weather weather);
    }
}
