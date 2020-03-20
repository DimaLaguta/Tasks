package API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IRest {
    @GET("Rates/{curID}")
    Call<Rate> getExchangeRate(@Path("curID") int curID);
}
