package com.andrewxa.rickandmorty.view.fragments.characters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.andrewxa.rickandmorty.R;
import com.andrewxa.rickandmorty.datasource.contract.Contract;
import com.andrewxa.rickandmorty.datasource.model.characters.Result;
import com.andrewxa.rickandmorty.presenter.CharactersPresenter;

import java.util.List;

public class CharactersFragment extends Fragment implements Contract.View {
    CharactersPresenter charactersPresenter;
    RecyclerView recyclerView;

    public CharactersFragment() {

    }

    public static CharactersFragment newInstance() {
        CharactersFragment fragment = new CharactersFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        android.view.View view = inflater.inflate(R.layout.characters_fragment, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.character_list);
        charactersPresenter = new CharactersPresenter(this,getContext());
        getAllCharacters();
        return view;
    }

    public void getAllCharacters() {
        charactersPresenter.requestAllCharacters();
    }

    public void showAllCharacters(List<Result> resultList) {
        CharacterAdapter characterAdapter = new CharacterAdapter(resultList, getContext());
        recyclerView.setAdapter(characterAdapter);
    }




}
