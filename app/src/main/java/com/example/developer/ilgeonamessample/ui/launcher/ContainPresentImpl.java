package com.example.developer.ilgeonamessample.ui.launcher;

import com.example.developer.ilgeonamessample.MyApplication;
import com.example.developer.ilgeonamessample.R;
import com.example.developer.ilgeonamessample.domain.entity.Bbox;
import com.example.developer.ilgeonamessample.domain.entity.Location;
import com.example.developer.ilgeonamessample.domain.entity.Weather;
import com.example.developer.ilgeonamessample.domain.entity.WeatherObservation;
import com.example.developer.ilgeonamessample.domain.interactor.GetLocationsInteractor;
import com.example.developer.ilgeonamessample.domain.interactor.GetLocationsInteractorImpl;
import com.example.developer.ilgeonamessample.domain.interactor.GetWaetherInteractor;
import com.example.developer.ilgeonamessample.domain.interactor.GetWeatherInteractorImpl;
import com.example.developer.ilgeonamessample.ui.searchable.SearchablePresenterImpl;
import com.example.developer.ilgeonamessample.ui.searchable.SearchableView;

import timber.log.Timber;

/**
 * Created by developer on 03/03/2018.
 */

public class ContainPresentImpl implements ContainPresent {

    private final int FIRST_ITEM = 0;
    private final int MAX_ROWS = 20;

    private final String LANG = "en";
    private final String STYLE = "FULL";
    private final String USERNAME_1 = "ilgeonamessample";
    private final String USERNAME_2 = "demo";

    private final int START_ROW = 0;
    private GetWaetherInteractor getWeatherInteractor;
    private GetLocationsInteractor getLocationsInteractor;

    private ContainView view;

    public ContainPresentImpl(ContainView view) {

        this.view = view;
        getLocationsInteractor = new GetLocationsInteractorImpl();
        getWeatherInteractor = new GetWeatherInteractorImpl();
    }


    @Override
    public void searchLocation(String location) {
        getLocationsInteractor.execute(location, MAX_ROWS, START_ROW, LANG, true, STYLE, USERNAME_1, new GetLocationsInteractor.OnGetLocationsListener() {



            @Override
            public void onGetLocationsSuccess(Location location) {

                if (!location.getGeonames().isEmpty()) {
                    iniView(location);
                    getWeather(location.getGeonames().get(FIRST_ITEM).getBbox());
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



    public void iniView(Location location) {
        if (view != null) {
            getWeather(location.getGeonames().get(FIRST_ITEM).getBbox());
            view.setName(location.getGeonames().get(FIRST_ITEM).getName());
            view.setCountryName(location.getGeonames().get(FIRST_ITEM).getCountryName());
            view.setMapPosition(Double.parseDouble(location.getGeonames().get(FIRST_ITEM).getLat()),
                    Double.parseDouble(location.getGeonames().get(FIRST_ITEM).getLng()));
        }
    }


    public void getWeather(Bbox bbox) {
        getWeatherInteractor.execute(bbox.getNorth(), bbox.getSouth(), bbox.getEast(), bbox.getWest(),
                USERNAME_1, new GetWaetherInteractor.OnGetWeatherListener() {
                    @Override
                    public void onGetWeatherSuccess(Weather weather) {
                        if (view != null) {
                            view.setTemperature(getMediumTemperature(weather));
                        }
                    }

                    @Override
                    public void onGetWeatherError(String error) {

                    }
                });
    }

    private int getMediumTemperature(Weather weather) {
        int mediumTemperature = 0;
        int div = 0;
        for (WeatherObservation weatherObservation : weather.getWeatherObservations()) {
            try {
                int temperature = Integer.parseInt(weatherObservation.getTemperature());
                if (temperature != 0) {
                    mediumTemperature += temperature;
                    ++div;
                }
            } catch (NumberFormatException e) {
                Timber.e("No se pudo parsear la temperatura");
            }
        }
        return mediumTemperature / div;
    }


}
