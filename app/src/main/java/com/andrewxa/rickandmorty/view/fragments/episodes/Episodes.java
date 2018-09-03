package com.andrewxa.rickandmorty.view.fragments.episodes;

import com.andrewxa.rickandmorty.datasource.model.episodes.Result;

import java.util.List;

public interface Episodes {
    void getAllEpisodes();

    void showAllEpisodes(List<Result> episodesResult);
}
