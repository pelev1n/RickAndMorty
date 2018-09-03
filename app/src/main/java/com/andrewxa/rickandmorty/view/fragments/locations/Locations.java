package com.andrewxa.rickandmorty.view.fragments.locations;

import com.andrewxa.rickandmorty.datasource.model.locations.Result;

import java.util.List;

public interface Locations {
    void getAllLocations();

    void showAllLocations(List<Result> locationsResult);
}
