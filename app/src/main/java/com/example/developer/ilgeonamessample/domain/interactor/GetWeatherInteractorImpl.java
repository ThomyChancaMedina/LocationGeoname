package com.example.developer.ilgeonamessample.domain.interactor;

import android.util.Log;

import com.example.developer.ilgeonamessample.domain.entity.Weather;
import com.example.developer.ilgeonamessample.domain.service.MyApiEndpointInterface;
import com.example.developer.ilgeonamessample.domain.service.ServiceManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by developer on 01/03/2018.
 */

public class GetWeatherInteractorImpl implements GetWaetherInteractor {
    private MyApiEndpointInterface myApiEndpointInterface;

    public GetWeatherInteractorImpl() {
        myApiEndpointInterface = ServiceManager.createWebService();
    }


    @Override
    public void execute(double north, double south, double east, double west, String username, final OnGetWeatherListener listener) {
        Call<Weather> call=myApiEndpointInterface.getWeather(north,south,east,west,username);
        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if(response.isSuccessful())

                    listener.onGetWeatherSuccess(response.body());

            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                listener.onGetWeatherError(t.toString());

            }
        });
    }
}
