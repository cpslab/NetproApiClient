package simple;

import okhttp3.*;

import java.io.IOException;

public class Main {
    public static OkHttpClient client = new OkHttpClient();
    public static final String SCHEME = "http";
    public static final String HOST = "httpbin.org";

    public static void main(String[] args) {
        gethttpHeader();
//        postData();
    }

    // このPCから送られたhttpヘッダを確認してみよう
    public static void gethttpHeader() {
        HttpUrl.Builder builder = new HttpUrl.Builder().scheme(SCHEME).host(HOST);
        HttpUrl url = builder.addPathSegment("headers").build();
        Request request = new Request.Builder()
                .url(url)
                .get().build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                System.out.println(result);
            }
        });
    }

    // 名前とパスワードを送ってみよう(適当な値で大丈夫です)
    public static void postData() {
        HttpUrl.Builder builder = new HttpUrl.Builder().scheme(SCHEME).host(HOST);
        HttpUrl url = builder.addPathSegment("post").build();

        RequestBody formBody = new FormBody.Builder()
                .add("username", "netpro tarou")
                .add("password", "netpro1234")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody).build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                System.out.println(result);
            }
        });
    }

    // put してみよう
    // public static void putData() {
    //     ...
    // }

    // hoge してみよう
    // public static void hoge() {
    //     ...
    // }
}

