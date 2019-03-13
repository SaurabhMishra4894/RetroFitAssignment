package com.example.jsonfetch.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.jsonfetch.R;
import com.example.jsonfetch.adapter.CountryAdapter;
import com.example.jsonfetch.model.Api;
import com.example.jsonfetch.model.Country;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowCountriesActivity extends AppCompatActivity {


    /**
     * onCreate method for ShowCountriesActivity which calls void function addCountry()
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addCountry();
    }


    /**
     * Method addCountry which takes data from the Base Url and convert it into Retrofit
     * Two methods have been override for call.enqueue
     *
     */
    protected void addCountry() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<ArrayList<Country>> call = api.getCountry();

        call.enqueue(new Callback<ArrayList<Country>>() {


            /**
             * Method onResponse returns country list to the CountryAdapter
             *
             * @param call
             * @param response
             */
            @Override
            public void onResponse(Call<ArrayList<Country>> call, Response<ArrayList<Country>> response) {
                ArrayList<Country> country = response.body();

                final RecyclerView countryRecyclerView = findViewById(R.id.main_activity_rl_countries);


                CountryAdapter countryAdapter = new CountryAdapter(getApplicationContext(), country);
                final RecyclerView.LayoutManager layoutManager =
                        new LinearLayoutManager(ShowCountriesActivity.this);
                countryRecyclerView.setLayoutManager(layoutManager);
                countryRecyclerView.setAdapter(countryAdapter);
            }

            /**
             * Method onFinally runs when an error has to be set if the JsonCall could not be made
             * Displays a toast id error persists
             *
             * @param call
             * @param t
             */
            @Override
            public void onFailure(Call<ArrayList<Country>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
