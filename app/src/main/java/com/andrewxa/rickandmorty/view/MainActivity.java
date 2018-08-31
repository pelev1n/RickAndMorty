package com.andrewxa.rickandmorty.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.andrewxa.rickandmorty.R;
import com.andrewxa.rickandmorty.datasource.contract.Contract;
import com.andrewxa.rickandmorty.datasource.model.Result;
import com.andrewxa.rickandmorty.presenter.Presenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.Model {

    Presenter presenter;
    RecyclerView recyclerView;
    CharacterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.character_list);

        presenter = new Presenter(this, this);

        getAllCharacters();
    }


    @Override
    public void getAllCharacters() {
        presenter.requestAllCharacters();
    }

    @Override
    public void showAllCharacters(List<Result> resultList) {
        CharacterAdapter characterAdapter = new CharacterAdapter(resultList, this);
        recyclerView.setAdapter(characterAdapter);
    }
}
