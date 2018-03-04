package com.example.developer.ilgeonamessample.domain.interactor;

import com.example.developer.ilgeonamessample.domain.entity.Weather;

/**
 * Created by developer on 01/03/2018.
 */

public interface GetWaetherInteractor {
    interface OnGetWeatherListener {
        void onGetWeatherSuccess(Weather weather);

        void onGetWeatherError(String error);
    }
    void execute(double north, double south, double east, double west, String username, OnGetWeatherListener listener);
}
