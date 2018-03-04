package com.example.developer.ilgeonamessample.util.suggestion;

import android.content.SearchRecentSuggestionsProvider;
import android.util.Log;

import timber.log.Timber;

/**
 * Created by developer on 01/03/2018.
 */
//lo que se hace aqui es un historial de toda las busqueda que se ha realizado

public class MySuggestionProvider extends SearchRecentSuggestionsProvider {

    public final static String AUTHORITY = "com.example.MySuggestionProvider";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public MySuggestionProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }
}
