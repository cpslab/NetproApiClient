package cps.network;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

import static cps.network.ApiConsts.*;

public class OkhttpApiClient {

    public static final String TAG = "DEBUG: " + OkhttpApiClient.class.getSimpleName() + ": ";

    private OkHttpClient client = new OkHttpClient();

    private Request request;

    private Gson gson = new Gson();

    public void fetchUsers(ApiClientCallback callback) {
        HttpUrl.Builder builder = buildUrl()
                .addPathSegment("users");
        get(builder, callback);
    }

    public void registerUser(String name, String password, ApiClientCallback callback) {
        HttpUrl.Builder builder = buildUrl()
                .addPathSegment("register");
        RequestBody formBody = new FormBody.Builder()
                .add("username", name)
                .add("password", password)
                .build();
        post(builder, formBody, callback);
    }

    public void login(String name, String password, ApiClientCallback callback) {
        HttpUrl.Builder builder = buildUrl()
                .addPathSegment("login");
        RequestBody formBody = new FormBody.Builder()
                .add("username", name)
                .add("password", password)
                .build();
        post(builder, formBody, callback);
    }

    private void get(HttpUrl.Builder builder, ApiClientCallback apiClientCallback) {
        request = new Request.Builder()
                .url(builder.build())
                .get().build();
        enqueue(request, apiClientCallback);
    }

    private void post(HttpUrl.Builder builder, RequestBody body, ApiClientCallback apiClientCallback) {
        request = new Request.Builder()
                .url(builder.build())
                .post(body).build();
        enqueue(request, apiClientCallback);
    }

    private void enqueue(Request request, ApiClientCallback apiClientCallback) {
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
                .addPathSegment(ROOT);
    }
}
