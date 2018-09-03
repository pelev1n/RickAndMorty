package com.andrewxa.rickandmorty.datasource.model.characters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharactersInfo {

    @SerializedName("info")
    @Expose
    private CharactersInfo info;

    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public CharactersInfo getInfo() {
        return info;
    }

    public void setInfo(CharactersInfo info) {
        this.info = info;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
