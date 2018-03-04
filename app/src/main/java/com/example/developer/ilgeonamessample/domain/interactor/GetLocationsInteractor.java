package com.example.developer.ilgeonamessample.domain.interactor;

import com.example.developer.ilgeonamessample.domain.entity.Location;

/**
 * Created by developer on 28/02/2018.
 */

public interface GetLocationsInteractor {

    interface OnGetLocationsListener {
        void onGetLocationsSuccess(Location location);

        void onGetLocationsError(String error);
    }

    void execute(String location, int maxRows, int startRow, String lang, boolean isNameRequired,
                 String style, String username, OnGetLocationsListener listener);

}
