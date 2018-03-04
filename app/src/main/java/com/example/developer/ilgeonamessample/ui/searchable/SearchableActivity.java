package com.example.developer.ilgeonamessample.ui.searchable;


import android.content.Intent;
import android.os.Bundle;

import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;

import android.view.View;

import android.widget.Button;
import android.widget.ProgressBar;

import android.widget.Toast;

import com.example.developer.ilgeonamessample.R;
import com.example.developer.ilgeonamessample.domain.entity.Location;
import com.example.developer.ilgeonamessample.ui.base.BaseActivity;
import com.example.developer.ilgeonamessample.ui.launcher.ContaineActivity;

import com.google.android.gms.maps.SupportMapFragment;



import java.io.Serializable;

import butterknife.BindView;

import butterknife.OnClick;

/**
 * Created by developer on 01/03/2018.
 */

public class SearchableActivity extends BaseActivity implements SearchableView {
    public static final String EXTRA_WORD = "la_palabra";
    SearchablePresenter presenter;


    @BindView(R.id.tiet_search)
    TextInputEditText textInputEditText;

    @BindView(R.id.btn_search)
    Button btnSearch;

    @BindView(R.id.pb_search)
    ProgressBar pbSearch;


    SupportMapFragment mapFragment;



    protected  void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        getSupportActionBar();

       presenter=new SearchablePresenterImpl(this);

    }



    /***quie esta el layout principal*/
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_enter;
    }



    @OnClick(R.id.btn_search)
    public void searchButtonClicked() {
      presenter.searchLocationClicked(textInputEditText.getText().toString());
    }



    /**star searchview*
     *
     *
     *
     * */
    @Override
    public void showProgressBar() {
        pbSearch.setVisibility(View.GONE);

    }

    @Override
    public void dismissProgressBar() {
        btnSearch.setEnabled(false);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void goToBooksActivity(String location) {

        Intent intent=new Intent(this, ContaineActivity.class);
        intent.putExtra(EXTRA_WORD, location);
        startActivity(intent);
    }

    @Override
    public void disableSignInButton() {
        btnSearch.setEnabled(false);

    }

    @Override
    public void enableSignInButton() {
        btnSearch.setEnabled(true);
    }
//news
//    @Override
//    public void setName(String name) {
//
//    }
//
//    @Override
//    public void setCountryName(String countryName) {
//
//    }
//
//    @Override
//    public void setMapPosition(double lat, double lng) {
//
//    }
//
//    @Override
//    public void setTemperature(int mediumTemperature) {
//
//    }


}
