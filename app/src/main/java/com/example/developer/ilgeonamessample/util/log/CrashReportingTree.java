package com.example.developer.ilgeonamessample.util.log;

import android.util.Log;

import timber.log.Timber;

/**
 * Created by developer on 01/03/2018.
 */

public class CrashReportingTree extends Timber.Tree {

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return;
        }
    }
}
