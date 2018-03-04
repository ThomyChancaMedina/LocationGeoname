package com.example.developer.ilgeonamessample.domain.service;

import com.example.developer.ilgeonamessample.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by developer on 28/02/2018.
 */

public class ServiceManager {
    public static MyApiEndpointInterface createWebService(){
        HttpLoggingInterceptor logging =new HttpLoggingInterceptor();
        logging.setLevel(Level.BODY);
        OkHttpClient.Builder httpClient=new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        return retrofit.create(MyApiEndpointInterface.class);
    }
}
