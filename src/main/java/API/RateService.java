package API;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RateService {
    public List<Rate> getRates(int ... curIDs) {
        List<Rate> rates = new ArrayList<>();
        for (int i : curIDs){
            rates.add(getRate(i));
        }
        return rates;
    }

    private Rate getRate(int curId) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.nbrb.by/API/ExRates/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        IRest m_restService = retrofit.create(IRest.class);
        Response<Rate> responseRate = null;

        try {
            responseRate = m_restService.getExchangeRate(curId).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseRate.body();
    }

}
