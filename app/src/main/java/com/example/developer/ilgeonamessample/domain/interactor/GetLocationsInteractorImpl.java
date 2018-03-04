package com.example.developer.ilgeonamessample.domain.interactor;

import android.util.Log;

import com.example.developer.ilgeonamessample.domain.entity.Geoname;
import com.example.developer.ilgeonamessample.domain.entity.Location;
import com.example.developer.ilgeonamessample.domain.service.MyApiEndpointInterface;
import com.example.developer.ilgeonamessample.domain.service.ServiceManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by developer on 28/02/2018.
 */

public class GetLocationsInteractorImpl implements GetLocationsInteractor {

    private MyApiEndpointInterface myApiEndpointInterface;

    public GetLocationsInteractorImpl() {
        myApiEndpointInterface = ServiceManager.createWebService();
    }


    @Override
    public void execute(String location, int maxRows, int startRow, String lang,
                        boolean isNameRequired, String style, String username,
                        final OnGetLocationsListener listener) {
        Call<Location> call = myApiEndpointInterface.getLocationsInfo(location, maxRows, startRow, lang, isNameRequired, style, username);
        call.enqueue(new Callback<Location>() {
            @Override
            public void onResponse(Call<Location> call, Response<Location> response) {
                if (response.isSuccessful())
//                    Log.i("thomy::::::::::: ", String.valueOf(response.body().getGeonames()));

                listener.onGetLocationsSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Location> call, Throwable t) {
                listener.onGetLocationsError(t.toString());

            }
        });

    }
}
