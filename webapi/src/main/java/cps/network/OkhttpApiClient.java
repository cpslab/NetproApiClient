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
        HttpUrl url = buildUrl()
                .addPathSegment("users")
                .build();
        get(url, callback);
    }

    public void registerUser(String name, String password, ApiClientCallback callback) {
        HttpUrl url = buildUrl()
                .addPathSegment("register")
                .build();
        RequestBody formBody = new FormBody.Builder()
                .add("username", name)
                .add("password", password)
                .build();
        post(url, formBody, callback);
    }

    public void login(String name, String password, ApiClientCallback callback) {
        HttpUrl url = buildUrl()
                .addPathSegment("login")
                .build();
        RequestBody formBody = new FormBody.Builder()
                .add("username", name)
                .add("password", password)
                .build();
        post(url, formBody, callback);
    }

    public void authentication(String token, ApiClientCallback callback) {
        HttpUrl url = buildUrl()
                .addPathSegment("is_auth")
                .build();
        Headers headers = Headers.of("Authentication", token);
        get(url, headers, callback);
    }

    private void get(HttpUrl url, ApiClientCallback apiClientCallback) {
        request = new Request.Builder()
                .url(url)
                .get().build();
        enqueue(request, apiClientCallback);
    }

    private void get(HttpUrl url, Headers headers, ApiClientCallback apiClientCallback) {
        request = new Request.Builder()
                .url(url)
                .headers(headers)
                .get().build();
        enqueue(request, apiClientCallback);
    }

    private void post(HttpUrl url, RequestBody body, ApiClientCallback apiClientCallback) {
        request = new Request.Builder()
                .url(url)
                .post(body).build();
        enqueue(request, apiClientCallback);
    }

    private void post(HttpUrl url, Headers headers, RequestBody body, ApiClientCallback apiClientCallback) {
        request = new Request.Builder()
                .url(url)
                .headers(headers)
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
