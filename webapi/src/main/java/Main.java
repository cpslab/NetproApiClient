import webapi.network.ApiClient;

public class Main {

    private static final int LOCATION_CODE_TOKYO = 400040;

    /**
     * API ドキュメント
     * http://weather.livedoor.com/weather_hacks/webservice
     *
     * 東京のロケーションコードは130010
     */
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        apiClient.getWeather(LOCATION_CODE_TOKYO,
                (call, weather) -> System.out.println(weather.toString()));
    }
}
