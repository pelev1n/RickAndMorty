package com.andrewxa.rickandmorty.datasource.network;

import com.andrewxa.rickandmorty.datasource.model.characters.CharactersInfo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RickAndMortyApi {

    @GET("character")
    Call<CharactersInfo> getAllCharachters();


}
