package com.andrewxa.rickandmorty.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrewxa.rickandmorty.R;

public class EpisodesFragment extends Fragment{

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
        View view = inflater.inflate(R.layout.characters_list, container, false);

        return view;
    }
}
