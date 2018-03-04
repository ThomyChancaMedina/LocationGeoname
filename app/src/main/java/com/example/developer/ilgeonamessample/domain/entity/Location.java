package com.example.developer.ilgeonamessample.domain.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by developer on 28/02/2018.
 */

public class Location {
    @SerializedName("totalResultsCount")
    @Expose
    private int totalResultsCount;

    @SerializedName("geonames")
    @Expose
    private List<Geoname> geonames;

    public int getTotalResultsCount() {
        return totalResultsCount;
    }

    public void setTotalResultsCount(int totalResultsCount) {
        this.totalResultsCount = totalResultsCount;
    }

    public List<Geoname> getGeonames() {
        return geonames;
    }

    public void setGeonames(List<Geoname> geonames) {
        this.geonames = geonames;
    }
}
