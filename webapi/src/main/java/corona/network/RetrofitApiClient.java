package corona.network;

import corona.entity.*;
import retrofit2.Call;
import retrofit2.http.GET;

import static corona.network.ApiConsts.*;

public interface RetrofitApiClient {

    @GET(ALL_PATH)
    Call<CovidEntity[]> getAllJp();
}
