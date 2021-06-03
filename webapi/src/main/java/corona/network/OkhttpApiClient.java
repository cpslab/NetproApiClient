package corona.network;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

import static corona.network.ApiConsts.*;

public class OkhttpApiClient {

    public static final String TAG = "DEBUG: " + OkhttpApiClient.class.getSimpleName() + ": ";

    private OkHttpClient client = new OkHttpClient();

    private Request request;

    private Gson gson = new Gson();
    

    public void getAll(ApiClientCallback apiClientCallback) {
        HttpUrl.Builder builder = buildUrl();
        enqueue(builder, apiClientCallback);
    }

    private void enqueue(HttpUrl.Builder builder, ApiClientCallback apiClientCallback) {
        request = new Request.Builder()
                .url(builder.build())
                .get().build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (apiClientCallback == null) {
                    System.out.println("apiClientCallback is null");
                    return;
                }

                apiClientCallback.onFailure(call, e);
            }

            @Override
            public void onResponse(Call call, Response response) {
                if (apiClientCallback == null) {
                    System.out.println("apiClientCallback is null");
                    return;
                }

                String result = null;
                try {
                    result = response.body().string();
                } catch (IOException e) {
                    apiClientCallback.onFailure(call, e);
                }

                apiClientCallback.onSuccess(call, result);
            }
        });
    }

    public interface ApiClientCallback {

        void onSuccess(Call call, String json);

        void onFailure(Call call, IOException e);
    }

    private HttpUrl.Builder buildUrl() {
        return new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(HOST)
                .addPathSegment(ALL_PATH);
    }
}
