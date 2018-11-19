package cps;

import cps.network.OkhttpApiClient;
import okhttp3.Call;

import java.io.IOException;

public class Main {

    private static OkhttpApiClient.ApiClientCallback callback = new OkhttpApiClient.ApiClientCallback() {
        @Override
        public void onSuccess(Call call, String json) {
            System.out.println(json);
        }

        @Override
        public void onFailure(Call call, IOException e) {

        }
    };

    public static void main(String[] args) {
//        gethttpHeader();
//          postData();
          putData();
    }

    // このPCから送られたhttpヘッダを確認してみよう
    private static void gethttpHeader() {
        OkhttpApiClient okhttpApiClient = new OkhttpApiClient();
        okhttpApiClient.httpHeader(callback);
    }

    // 名前とパスワードを送ってみよう(適当な値で大丈夫です)
    private static void postData() {
        OkhttpApiClient okhttpApiClient = new OkhttpApiClient();
        okhttpApiClient.sendData("netpro", "netpro1234", callback);
    }

    private static void putData() {
        OkhttpApiClient okhttpApiClient = new OkhttpApiClient();
        okhttpApiClient.putData(callback);
    }

}
