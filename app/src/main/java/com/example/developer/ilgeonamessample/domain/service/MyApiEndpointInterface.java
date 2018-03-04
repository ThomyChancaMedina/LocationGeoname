package com.example.developer.ilgeonamessample.domain.service;

import com.example.developer.ilgeonamessample.domain.entity.Location;
import com.example.developer.ilgeonamessample.domain.entity.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by developer on 28/02/2018.
 */

public interface MyApiEndpointInterface {
    @GET("searchJSON")
    Call<Location> getLocationsInfo(
            @Query("q") String city,
            @Query("maxRows") int maxRows,
            @Query("startRows")int starRow,
            @Query("lang") String language,
            @Query("isNameRequired") boolean isNameRequired,
            @Query("style") String style,
            @Query("username") String username

    );

    @GET("weatherJSON")
    Call<Weather> getWeather(
      @Query("north") double north,
      @Query("south") double south,
      @Query("east") double east,
      @Query("west") double west,
      @Query("username") String username
    );
}
