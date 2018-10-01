package com.andrewxa.rickandmorty.presenter;

import android.content.Context;

import com.andrewxa.rickandmorty.RickAndMortyApp;
import com.andrewxa.rickandmorty.datasource.contract.Contract;
import com.andrewxa.rickandmorty.datasource.model.characters.CharactersInfo;
import com.andrewxa.rickandmorty.view.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter implements Contract.Presenter{

    Context mContext;
    Contract.View view;

    public Presenter(MainActivity view, Context context) {
        this.mContext = context;
        this.view = view;
    }

    public void requestAllCharacters() {
        Call<CharactersInfo> charachters = RickAndMortyApp.getRickAndMortyApi().getAllCharachters();
        charachters.enqueue(new Callback<CharactersInfo>() {
            @Override
            public void onResponse(Call<CharactersInfo> call, Response<CharactersInfo> response) {
                view.showAllCharacters(response.body().getResults());
            }

            @Override
            public void onFailure(Call<CharactersInfo> call, Throwable t) {

            }
        });
    }
}
