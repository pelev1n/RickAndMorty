package com.andrewxa.rickandmorty.presenter;

import android.content.Context;

import com.andrewxa.rickandmorty.RickAndMortyApp;
import com.andrewxa.rickandmorty.datasource.model.locations.LocationsInfo;
import com.andrewxa.rickandmorty.view.fragments.locations.Locations;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationsPresenter{
    Context mContext;
    Locations view;

    public LocationsPresenter(Locations view, Context context) {
        this.mContext = context;
        this.view = view;
    }

    public void requestAllLocations() {
        Call<LocationsInfo> locations = RickAndMortyApp.getRickAndMortyApi().getAllLocations();
        locations.enqueue(new Callback<LocationsInfo>() {
            @Override
            public void onResponse(Call<LocationsInfo> call, Response<LocationsInfo> response) {
                view.showAllLocations(response.body().getResults());
            }

            @Override
            public void onFailure(Call<LocationsInfo> call, Throwable t) {

            }
        });
    }
}
