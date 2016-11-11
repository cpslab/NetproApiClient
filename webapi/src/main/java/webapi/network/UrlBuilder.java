package webapi.network;

import okhttp3.HttpUrl;

/**
 * JSONデータをリクエストする際のベースとなるURL
 * http://weather.livedoor.com/forecast/webservice/json/v1
 *
 * doc -> http://weather.livedoor.com/weather_hacks/webservice
 */
public class UrlBuilder {

    public static final String SCHEME = "http";

    public static final String HOST = "weather.livedoor.com";

    public static final String FORECAST = "forecast";

    public static final String WEB_SERVICE = "webservice";

    public static final String JSON = "json";

    public static final String ROOT = "v1";

    public static HttpUrl.Builder buildUrl() {
        return new HttpUrl.Builder()
                .scheme(SCHEME)
                .host(HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(WEB_SERVICE)
                .addPathSegment(JSON)
                .addPathSegment(ROOT);
    }
}
