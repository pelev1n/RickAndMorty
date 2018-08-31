package com.andrewxa.rickandmorty.datasource.contract;
import com.andrewxa.rickandmorty.datasource.model.Result;

import java.util.List;

public class Contract {
    public interface Model {
        void getAllCharacters();
        void showAllCharacters(List<Result> resultList);
    }

    public interface Presenter {
        void requestAllCharacters();
    }
}
