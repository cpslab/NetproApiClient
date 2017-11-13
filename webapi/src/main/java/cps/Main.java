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
        fetchUsers();
        register();
        login();
    }

    private static void fetchUsers() {
        OkhttpApiClient okhttpApiClient = new OkhttpApiClient();
        okhttpApiClient.fetchUsers(callback);
    }

    private static void register() {
        OkhttpApiClient okhttpApiClient = new OkhttpApiClient();
        okhttpApiClient.registerUser("naoya", "naoya1234", callback);
    }

    private static void login() {
        OkhttpApiClient okhttpApiClient = new OkhttpApiClient();
        okhttpApiClient.login("naoya", "naoya1234", callback);
    }

    private static void authentication() {
        // TODO: 2017/11/13 endpointどうするか
    }

}
