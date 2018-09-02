package com.andrewxa.rickandmorty.view;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.andrewxa.rickandmorty.R;
import com.andrewxa.rickandmorty.datasource.contract.Contract;
import com.andrewxa.rickandmorty.datasource.model.Result;
import com.andrewxa.rickandmorty.presenter.Presenter;
import com.andrewxa.rickandmorty.view.fragments.CharactersFragment;
import com.andrewxa.rickandmorty.view.fragments.EpisodesFragment;
import com.andrewxa.rickandmorty.view.fragments.LocationsFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.Model {

    Presenter presenter;
    RecyclerView recyclerView;
    CharacterAdapter adapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initTabLayoutViewPager();

        View headerView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.custom_tab_clicked, null, false);


        CardView cardView = (CardView) headerView.findViewById(R.id.custom_card);

        tabLayout.getTabAt(0).setCustomView(R.layout.custom_tab_clicked);
        tabLayout.getTabAt(1).setCustomView(R.layout.custom_tab_clicked);
        tabLayout.getTabAt(2).setCustomView(R.layout.custom_tab_clicked);


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
        tabLayout = findViewById(R.id.tablayout_id);

        ViewPager viewPager = findViewById(R.id.viewpager_id);
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());

        adapter.addFragment(CharactersFragment.newInstance(),"Characters");
        adapter.addFragment(LocationsFragment.newInstance(),"Locations");
        adapter.addFragment(EpisodesFragment.newInstance(),"Episodes");


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
