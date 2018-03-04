package com.example.developer.ilgeonamessample.ui.launcher;

/**
 * Created by developer on 03/03/2018.
 */

public interface ContainView  {

    void setName(String name);

    void setCountryName(String countryName);

    void setMapPosition(double lat, double lng);

    void setTemperature(int mediumTemperature);

    void showMessage(String message);


}
