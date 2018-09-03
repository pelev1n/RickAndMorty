package com.andrewxa.rickandmorty.view;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andrewxa.rickandmorty.R;
import com.andrewxa.rickandmorty.datasource.contract.Contract;
import com.andrewxa.rickandmorty.datasource.model.Result;
import com.andrewxa.rickandmorty.presenter.Presenter;
import com.andrewxa.rickandmorty.view.fragments.characters.CharacterAdapter;
import com.andrewxa.rickandmorty.view.fragments.characters.CharactersFragment;
import com.andrewxa.rickandmorty.view.fragments.EpisodesFragment;
import com.andrewxa.rickandmorty.view.fragments.locations.LocationsFragment;

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
        initTabsView();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                CardView cardView = (CardView) view.findViewById(R.id.custom_card);
                cardView.setRadius(10);
                cardView.setCardElevation(0);
                cardView.setCardBackgroundColor(Color.parseColor("#E53935"));
                TextView selectedText = (TextView) view.findViewById(R.id.custom_card_nameView);
                selectedText.setTextColor(Color.parseColor("#FFFFFF"));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                CardView cardView = (CardView) view.findViewById(R.id.custom_card);
                cardView.setRadius(10);
                cardView.setCardElevation(0);
                cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                TextView selectedText = (TextView) view.findViewById(R.id.custom_card_nameView);
                selectedText.setTextColor(Color.parseColor("#656589"));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.character_list);
        presenter = new Presenter(this, this);

        /*getAllCharacters();*/
        /*Intent intent = new Intent(this,CharactersFragment.class);
        startActivity(intent);*/
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


    public void initTabsView() {
        RelativeLayout tabCharacters = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        TextView cardCharTextView = (TextView) tabCharacters.findViewById(R.id.custom_card_nameView);
        cardCharTextView.setText("Characters");
        tabLayout.getTabAt(0).setCustomView(tabCharacters);

        RelativeLayout tabLocations = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        TextView cardLocTextView = (TextView) tabLocations.findViewById(R.id.custom_card_nameView);
        cardLocTextView.setText("Locations");
        tabLayout.getTabAt(1).setCustomView(tabLocations);

        RelativeLayout tabEpisodes = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        TextView cardEpTextView = (TextView) tabEpisodes.findViewById(R.id.custom_card_nameView);
        cardEpTextView.setText("Episodes");
        tabLayout.getTabAt(2).setCustomView(tabEpisodes);
    }
    @Override
    public void getAllCharacters() {
        presenter.requestAllCharacters();
    }

    @Override
    public void showAllCharacters(List<Result> resultList) {
        /*CharacterAdapter characterAdapter = new CharacterAdapter(resultList, this);
        recyclerView.setAdapter(characterAdapter);*/
    }
}
