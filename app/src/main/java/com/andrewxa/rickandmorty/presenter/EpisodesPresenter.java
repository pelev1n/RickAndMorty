package com.andrewxa.rickandmorty.presenter;

import android.content.Context;

import com.andrewxa.rickandmorty.RickAndMortyApp;
import com.andrewxa.rickandmorty.datasource.contract.Contract;
import com.andrewxa.rickandmorty.datasource.model.characters.CharactersInfo;
import com.andrewxa.rickandmorty.datasource.model.episodes.EpisodesInfo;
import com.andrewxa.rickandmorty.view.fragments.characters.CharactersFragment;
import com.andrewxa.rickandmorty.view.fragments.episodes.Episodes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodesPresenter {
    Context mContext;
    Episodes view;

    public EpisodesPresenter(Episodes view, Context context) {
        this.mContext = context;
        this.view = view;
    }

    public void requestAllEpisodes() {
        Call<EpisodesInfo> episodes = RickAndMortyApp.getRickAndMortyApi().getAllEpisodes();
        episodes.enqueue(new Callback<EpisodesInfo>() {
            @Override
            public void onResponse(Call<EpisodesInfo> call, Response<EpisodesInfo> response) {
                view.showAllEpisodes(response.body().getResults());
            }

            @Override
            public void onFailure(Call<EpisodesInfo> call, Throwable t) {

            }
        });
    }
}
