package com.example.developer.ilgeonamessample.ui.searchable;

import android.util.Log;

import com.example.developer.ilgeonamessample.MyApplication;
import com.example.developer.ilgeonamessample.R;
import com.example.developer.ilgeonamessample.domain.entity.Bbox;
import com.example.developer.ilgeonamessample.domain.entity.Geoname;
import com.example.developer.ilgeonamessample.domain.entity.Location;
import com.example.developer.ilgeonamessample.domain.entity.Weather;
import com.example.developer.ilgeonamessample.domain.entity.WeatherObservation;
import com.example.developer.ilgeonamessample.domain.interactor.GetLocationsInteractor;
import com.example.developer.ilgeonamessample.domain.interactor.GetLocationsInteractor.OnGetLocationsListener;
import com.example.developer.ilgeonamessample.domain.interactor.GetLocationsInteractorImpl;
import com.example.developer.ilgeonamessample.domain.interactor.GetWaetherInteractor;
import com.example.developer.ilgeonamessample.domain.interactor.GetWaetherInteractor.OnGetWeatherListener;

import com.example.developer.ilgeonamessample.domain.interactor.GetWeatherInteractorImpl;


import timber.log.Timber;

/**
 * Created by developer on 01/03/2018.
 */

public class SearchablePresenterImpl implements SearchablePresenter {

    private final int FIRST_ITEM = 0;
    private final int MAX_ROWS = 20;
    private final int STAR_ROW = 0;

    private final String LANG = "en";
    private final String STYLE = "FULL";
    private final String USERNAME_1 = "ilgeonamessample";
    private final String USERNAME_2 = "demo";

    private static String cityName;

    private SearchableView view;
    private GetLocationsInteractor getLocationsInteractor;
    private GetWaetherInteractor getWeatherInteractor;

    public SearchablePresenterImpl(SearchableView view) {

        this.view = view;
        getLocationsInteractor = new GetLocationsInteractorImpl();
        getWeatherInteractor = new GetWeatherInteractorImpl();

    }

    //el boton de buqueda
    @Override
    public void searchLocationClicked(String location) {
        cityName = location;

        getLocationsInteractor.execute(location, MAX_ROWS, STAR_ROW, LANG, true, STYLE, USERNAME_1, new OnGetLocationsListener() {


            @Override
            public void onGetLocationsSuccess(Location location) {

                //Log.i("", city);
                if (!location.getGeonames().isEmpty()) {

                    view.disableSignInButton();
                    view.enableSignInButton();
                    for (Geoname city : location.getGeonames()) {

                        if(!city.getName().toString().isEmpty()){

                            Log.i("city::::::: ", city.getName().toString());

                            view.goToBooksActivity(cityName);
                        }else {
                            view.showMessage("error");
                        }

                    }



//                    initView(location);
//                    getWeather(location.getGeonames().get(FIRST_ITEM).getBbox());
                } else {
                    if (view != null) {
                        view.showMessage(
                                MyApplication.getContext().getResources().getString(R.string.error_city));

                    }
                }
            }

            @Override
            public void onGetLocationsError(String error) {

            }
        });

    }
//fin


}
