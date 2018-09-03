package com.andrewxa.rickandmorty.view.fragments.episodes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrewxa.rickandmorty.R;
import com.andrewxa.rickandmorty.datasource.model.episodes.Result;

import java.util.List;

public class EpisodesFragment extends Fragment implements Episodes{

    public EpisodesFragment() {

    }

    public static EpisodesFragment newInstance() {
        EpisodesFragment fragment = new EpisodesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.episodes_fragment, container, false);

        return view;
    }

    @Override
    public void getAllEpisodes() {

    }

    @Override
    public void showAllEpisodes(List<Result> episodesResult) {

    }
}
