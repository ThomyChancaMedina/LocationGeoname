package com.example.developer.ilgeonamessample.domain.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by developer on 28/02/2018.
 */

public class Time {
    @SerializedName("gmtOffset")
    @Expose
    private int gmtOffset;
    @SerializedName("timeZoneId")
    @Expose
    private String timeZoneId;
    @SerializedName("dstOffset")
    @Expose
    private int dstOffset;

    public int getGmtOffset() {
        return gmtOffset;
    }

    public void setGmtOffset(int gmtOffset) {
        this.gmtOffset = gmtOffset;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public int getDstOffset() {
        return dstOffset;
    }

    public void setDstOffset(int dstOffset) {
        this.dstOffset = dstOffset;
    }
}
