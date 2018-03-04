package com.example.developer.ilgeonamessample;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import timber.log.Timber;

public class MyApplication extends Application {

    private static Context context;

    @Override
   public void onCreate(){
        super.onCreate();
        context=this;
        configTimber();
    }

    private void configTimber(){
       if(BuildConfig.DEBUG){
           Timber.plant(new Timber.DebugTree());

       }else {
//          Timber.plant(new CrashReportingTree());
       }
    }
    public static Context getContext(){
        return context;
    }
}
