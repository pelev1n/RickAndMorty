package com.andrewxa.rickandmorty;

import android.app.Application;

import com.andrewxa.rickandmorty.datasource.network.RickAndMortyApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RickAndMortyApp extends Application {

    private static RickAndMortyApp application;
    private static RickAndMortyApi rickAndMortyApi;


    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        rickAndMortyApi = initApi().create(RickAndMortyApi.class);

    }

    public static RickAndMortyApp getApplication() {
        return application;
    }

    public static void setApplication(RickAndMortyApp application) {
        RickAndMortyApp.application = application;
    }

    public static RickAndMortyApi getRickAndMortyApi() {
        return rickAndMortyApi;
    }


    private static Retrofit initApi() {
        return new Retrofit.Builder()
                .baseUrl(baseUrl())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(initClient())
                .build();
    }



    private static OkHttpClient initClient() {
        OkHttpClient.Builder builderArena = initBuilder();
        OkHttpClient client = builderArena.build();
        return client;
    }

    private static OkHttpClient.Builder initBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(5, TimeUnit.SECONDS);
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        return builder;
    }

    private static String baseUrl() {
        return "https://rickandmortyapi.com/api/";
    }
}
