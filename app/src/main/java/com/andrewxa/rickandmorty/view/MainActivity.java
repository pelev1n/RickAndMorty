package com.andrewxa.rickandmorty.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

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
        initToolbar();
        initTabLayoutViewPager();
        recyclerView = (RecyclerView) findViewById(R.id.character_list);

        presenter = new Presenter(this, this);

        getAllCharacters();
    }


    public void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        toolbar.setTitle("Rick and Morty");
        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void initTabLayoutViewPager() {
        TabLayout tabLayout = findViewById(R.id.tablayout_id);

        ViewPager viewPager = findViewById(R.id.viewpager_id);
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());

        adapter.addFragment(CharactersFragment.newInstance(arenaAccInfo),"Characters");
        adapter.addFragment(LocationsFragment.newInstance(arenaAccInfo),"Locations");
        adapter.addFragment(EpisodesFragment.newInstance(arenaAccInfo),"Episodes");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
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
