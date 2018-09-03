package com.andrewxa.rickandmorty.view.fragments.locations;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrewxa.rickandmorty.R;
import com.andrewxa.rickandmorty.presenter.CharactersPresenter;
import com.andrewxa.rickandmorty.presenter.LocationsPresenter;

public class LocationsFragment extends Fragment implements Locations{

    RecyclerView recyclerView;
    LocationsPresenter locationsPresenter;

    public LocationsFragment() {

    }

    public static LocationsFragment newInstance() {
        LocationsFragment fragment = new LocationsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.locations_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.locations_list);
        locationsPresenter = new CharactersPresenter(this,getContext());
        getAllCharacters();

        return view;
    }

    @Override
    public void getAllLocations() {

    }
}
