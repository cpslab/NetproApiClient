package cps.network;

import com.google.gson.Gson;
import okhttp3.*;
import okio.BufferedSink;

import java.io.IOException;

import static cps.network.ApiConsts.*;

public class OkhttpApiClient {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static final String TAG = "DEBUG: " + OkhttpApiClient.class.getSimpleName() + ": ";

    private OkHttpClient client = new OkHttpClient();

    private Request request;

    private Gson gson = new Gson();

    public void httpHeader(ApiClientCallback callback) {
        HttpUrl url = buildUrl()
                .addPathSegment("headers")
                .build();
        get(url, callback);
    }

    public void ipAddress(ApiClientCallback callback) {
        HttpUrl url = buildUrl()
                .addPathSegment("ip")
                .build();
        get(url, callback);
    }

    public void sendData(String name, String password, ApiClientCallback callback) {
        HttpUrl url = buildUrl()
                .addPathSegment("post")
                .build();
        RequestBody formBody = new FormBody.Builder()
                .add("username", name)
                .add("password", password)
                .build();
        post(url, formBody, callback);
    }

    public void putData(ApiClientCallback callback){
        // Q2. headerを付与してputせよ(実行結果を提出)
        // Q3. bodyを付与してputせよ(実行結果を提出)
    }




    /**
     *
     * @param url
     * @param apiClientCallback
     *
     * 以下のメソッドはhttpリクエストを送る際に使用するメソッド(get, post, put.. etc.)
     * 必要に応じて書き加える
     */
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

    //Q1. 以下のputメソッドを完成させよ.
    private void put(HttpUrl url, Headers headers, RequestBody body, ApiClientCallback apiClientCallback) {
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
                .host(HOST);
    }
}
