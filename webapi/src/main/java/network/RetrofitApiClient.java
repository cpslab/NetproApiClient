package network;

import entity.WeatherEntity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static network.ApiConsts.*;

public interface RetrofitApiClient {

    @GET(FORECAST + "/" + WEB_SERVICE + "/" + JSON + "/" + ROOT)
    Call<WeatherEntity> getWeather(@Query("city") int locationCode);
}
