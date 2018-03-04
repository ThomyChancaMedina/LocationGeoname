package com.example.developer.ilgeonamessample.domain.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by developer on 28/02/2018.
 */

public class Weather {
    @SerializedName("weatherObservations")
    @Expose
    private List<WeatherObservation> weatherObservations;

    public List<WeatherObservation> getWeatherObservations() {
        return weatherObservations;
    }

    public void setWeatherObservations(
            List<WeatherObservation> weatherObservations) {
        this.weatherObservations = weatherObservations;
    }
}
