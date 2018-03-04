package com.example.developer.ilgeonamessample.ui.launcher;



import com.example.developer.ilgeonamessample.R;
import com.example.developer.ilgeonamessample.domain.entity.Location;

import android.animation.ObjectAnimator;
import android.app.SearchManager;
import com.example.developer.ilgeonamessample.ui.base.BaseActivity;
import com.example.developer.ilgeonamessample.ui.searchable.SearchableActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import butterknife.BindView;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.support.v7.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by developer on 01/03/2018.
 */

public class ContaineActivity extends BaseActivity implements ContainView {


    private ContainPresent present;

    private String query ;








    @BindView(R.id.tv_name)
    TextView name_;

    @BindView(R.id.tv_country_name)
    TextView contry_Name;

    @BindView(R.id.toobar_con)
    Toolbar toolbarCon;

    SupportMapFragment mapFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar();

        setSupportActionBar(toolbarCon);
        toolbarCon.setTitle(getTitle());



        toolbarCon.setTitle(getTitle());

       Bundle extras=getIntent().getExtras();
       String city=extras.getString(SearchableActivity.EXTRA_WORD);
       // Location city=(Location)getIntent().getSerializableExtra(SearchableActivity.EXTRA_WORD.toString());

        generateLocation(city);

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_search2;
    }



    public void generateLocation(String city){
        present=new ContainPresentImpl(this);
        /**quei esl elemento de localizacion*/
        present.searchLocation(city);

        mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        SearchManager searchManager=(SearchManager)getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView=(SearchView)menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));


        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent){
        if(Intent.ACTION_SEARCH.equals(intent.getAction())){
            query= intent.getStringExtra(SearchManager.QUERY);
            generateLocation(query);
        }
    }

    /**
     *
     * Start ContainView
     *
     */

    @Override
    public void setName(String name) {
    name_.setText(name);
    }

    @Override
    public void setCountryName(String countryName) {
    contry_Name.setText(countryName);
    }

    @Override
    public void setMapPosition(final double lat,final double lng) {
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                final LatLng LOCATION_=new LatLng(lat,lng);
                CameraPosition cameraPosition=new CameraPosition.Builder()
                        .target(LOCATION_)
                        .zoom(15)
                        .tilt(30)
                        .build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });


    }

    @Override
    public void setTemperature(int mediumTemperature) {
        ProgressBar mProg=(ProgressBar)findViewById(R.id.pb_loading);
        ObjectAnimator progAnima=ObjectAnimator.ofInt(mProg,"progress",0,mediumTemperature);
        progAnima.setDuration(1000);
        progAnima.setInterpolator(new LinearInterpolator());
        progAnima.start();

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

    }
}






//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater inflater=getMenuInflater();
//        inflater.inflate(R.menu.options_menu, menu);
//
//        SearchManager searchManager =
//                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView =
//                (SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setSearchableInfo(
//                searchManager.getSearchableInfo(new ComponentName(this, SearchableActivity.class)));
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                Timber.i("he cliackado buscar");
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
//        return true;
//    }