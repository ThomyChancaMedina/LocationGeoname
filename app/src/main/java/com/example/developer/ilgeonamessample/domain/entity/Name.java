package com.example.developer.ilgeonamessample.domain.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by developer on 28/02/2018.
 */

public class Name {


    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("lang")
    @Expose
    private String lang;

    @SerializedName("isShortName")
    @Expose
    private String isShortName;

    @SerializedName("isPreferredName")
    @Expose
    private boolean isPreferredName;

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getIsShortName() {
        return isShortName;
    }

    public void setIsShortName(String isShortName) {
        this.isShortName = isShortName;
    }

    public boolean isPreferredName() {
        return isPreferredName;
    }

    public void setPreferredName(boolean preferredName) {
        isPreferredName = preferredName;
    }

}
