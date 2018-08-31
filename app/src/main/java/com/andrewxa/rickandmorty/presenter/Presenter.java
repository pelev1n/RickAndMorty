package com.andrewxa.rickandmorty.presenter;

import android.content.Context;
import android.view.View;

import com.andrewxa.rickandmorty.RickAndMortyApp;
import com.andrewxa.rickandmorty.datasource.model.CharactersInfo;
import com.andrewxa.rickandmorty.datasource.model.Result;
import com.andrewxa.rickandmorty.view.CharacterAdapter;
import com.andrewxa.rickandmorty.view.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter {

    Context mContext;
    MainActivity view;

    public Presenter(MainActivity view, Context context) {
        this.mContext = context;
        this.view = view;
    }

    public void getAllCharacters() {
        Call<CharactersInfo> charachters = RickAndMortyApp.getRickAndMortyApi().getAllCharachters();
        charachters.enqueue(new Callback<CharactersInfo>() {
            @Override
            public void onResponse(Call<CharactersInfo> call, Response<CharactersInfo> response) {
                List<Result> result = response.body().getResults();
                view.viewAllCharacters(result);
            }

            @Override
            public void onFailure(Call<CharactersInfo> call, Throwable t) {

            }
        });
    }
}
