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
//        fetchUsers();
//        register();
//        login();
//        authentication();
    }

    // TODO: Tutorial1
    private static void fetchUsers() {
        OkhttpApiClient okhttpApiClient = new OkhttpApiClient();
        okhttpApiClient.fetchUsers(callback);
    }

    // TODO: Tutorial2
    private static void register() {
        OkhttpApiClient okhttpApiClient = new OkhttpApiClient();
        okhttpApiClient.registerUser("netpro", "netpro1234", callback);
    }

    // TODO: Tutorial3
    private static void login() {
        OkhttpApiClient okhttpApiClient = new OkhttpApiClient();
        okhttpApiClient.login("netpro", "netpro1234", callback);
    }

    // TODO: Tutorial4
    private static void authentication() {
        OkhttpApiClient okhttpApiClient = new OkhttpApiClient();
        okhttpApiClient.authentication("your token", callback);
    }

}
