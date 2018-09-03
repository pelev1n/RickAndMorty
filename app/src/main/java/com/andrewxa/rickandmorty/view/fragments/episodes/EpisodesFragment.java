package com.andrewxa.rickandmorty.view.fragments.episodes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrewxa.rickandmorty.R;
import com.andrewxa.rickandmorty.datasource.model.episodes.Result;
import com.andrewxa.rickandmorty.presenter.EpisodesPresenter;
import com.andrewxa.rickandmorty.presenter.LocationsPresenter;
import com.andrewxa.rickandmorty.view.fragments.locations.LocationsAdapter;

import java.util.List;

public class EpisodesFragment extends Fragment implements Episodes{

    RecyclerView recyclerView;
    EpisodesPresenter episodesPresenter;

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

        recyclerView = (RecyclerView) view.findViewById(R.id.episodes_list);
        episodesPresenter = new EpisodesPresenter(this,getContext());
        getAllEpisodes();

        return view;
    }

    @Override
    public void getAllEpisodes() {
        episodesPresenter.requestAllEpisodes();
    }

    @Override
    public void showAllEpisodes(List<Result> episodesResult) {
        EpisodesAdapter episodesAdapter = new EpisodesAdapter(episodesResult, getContext());
        recyclerView.setAdapter(episodesAdapter);

    }
}
