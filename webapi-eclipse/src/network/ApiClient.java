package network;

import java.io.IOException;

import com.google.gson.Gson;

import entity.WeatherEntity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiClient {

    public static final String SCHEME = "http";

    public static final String HOST = "weather.livedoor.com";

    public static final String FORECAST = "forecast";

    public static final String WEB_SERVICE = "webservice";

    public static final String JSON = "json";

    public static final String ROOT = "v1";

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
        HttpUrl.Builder builder = buildUrl();
        builder.addQueryParameter("city", String.valueOf(locationCode));
        enqueue(builder, apiClientCallback);
    }

    private void enqueue(HttpUrl.Builder builder, ApiClientCallback apiClientCallback) {
        request = new Request.Builder()
                .url(builder.build())
                .get().build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                apiClientCallback.onFailure(call, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                apiClientCallback.onSuccess(call, gson.fromJson(result, WeatherEntity.class));
            }
        });
    }

    public interface ApiClientCallback {

        void onFailure(Call call, IOException e);

        void onSuccess(Call call, WeatherEntity weather);
    }

    private HttpUrl.Builder buildUrl() {
        return new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(WEB_SERVICE)
                .addPathSegment(JSON)
                .addPathSegment(ROOT);
    }
}
