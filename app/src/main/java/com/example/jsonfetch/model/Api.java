package com.example.jsonfetch.model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * An interface Api has been created which will help in order to save Base Url
 * of the Json File API
 *
 */
public interface Api {
    String BASE_URL = "https://restcountries.eu/rest/v2/";

    @GET("all?fields=name;capital")
    Call<ArrayList<Country>> getCountry();
}
