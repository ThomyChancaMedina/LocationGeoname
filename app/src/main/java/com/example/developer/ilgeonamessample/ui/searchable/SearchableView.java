package com.example.developer.ilgeonamessample.ui.searchable;

import com.example.developer.ilgeonamessample.domain.entity.Location;

/**
 * Created by developer on 01/03/2018.
 */

public interface SearchableView {
//    void setName(String name);
//    void setCountryName(String countryName);
//    void setMapPosition(double lat,double lng);
//    void setTemperature(int mediumTemperature);
//    void showMessage(String message );

    void showProgressBar();
    void dismissProgressBar();
    void showMessage(String message);
    void goToBooksActivity(String palabra);
    void disableSignInButton();
    void enableSignInButton();

    //
//      void setName(String name);
//    void setCountryName(String countryName);
//    void setMapPosition(double lat,double lng);
//    void setTemperature(int mediumTemperature);

}
