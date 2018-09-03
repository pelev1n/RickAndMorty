package com.andrewxa.rickandmorty.presenter;

import android.content.Context;

import com.andrewxa.rickandmorty.RickAndMortyApp;
import com.andrewxa.rickandmorty.datasource.contract.Contract;
import com.andrewxa.rickandmorty.datasource.model.characters.CharactersInfo;
import com.andrewxa.rickandmorty.view.fragments.characters.CharactersFragment;
import com.andrewxa.rickandmorty.view.fragments.locations.Locations;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationsPresenter {
    Context mContext;
    Locations view;

    public LocationsPresenter(Locations view, Context context) {
        this.mContext = context;
        this.view = view;
    }

    public void requestAllLocations() {
        Call<CharactersInfo> charachters = RickAndMortyApp.getRickAndMortyApi().getAllCharachters();
        charachters.enqueue(new Callback<CharactersInfo>() {
            @Override
            public void onResponse(Call<CharactersInfo> call, Response<CharactersInfo> response) {
                view.showAllLocations(response.body().getResults());
            }

            @Override
            public void onFailure(Call<CharactersInfo> call, Throwable t) {

            }
        });
    }
}
