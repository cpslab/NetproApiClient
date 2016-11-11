import webapi.network.ApiClient;

public class Main {

    private static final int LOCATION_CODE_TOKYO = 130010;

    public static void main(String[] args) {
        printWeather();
    }

    private static void printWeather() {
        ApiClient apiClient = new ApiClient();
        apiClient.getWeather(LOCATION_CODE_TOKYO,
                (call, weather) -> System.out.println(weather.toString()));
    }
}
