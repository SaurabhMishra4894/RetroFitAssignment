package com.example.jsonfetch.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.jsonfetch.R;
import com.example.jsonfetch.model.Country;


import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Country> countryArrayList;


    /**
     * CountryAdapter constructor sets the values in the ArrayList and Context
     *
     * @param countryList ArrayList for Storing Countries
     */

    public CountryAdapter(Context context, ArrayList<Country> countryList){
        countryArrayList = countryList;
    }

    /**
     * Function CreateViewHolder in order to create ViewHolder
     *
     * @param viewGroup Use tp get the Context of ViewGroup
     * @param i
     * @return
     */

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,final int i) {
        View layoutInflater = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_country_view,viewGroup,false);
        return new CountryViewHolder(layoutInflater);

    }


    /**
     * function BindViewHolder in order to bind data to the ViewHolder
     *
     * @param viewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        CountryViewHolder countryViewHolder = (CountryViewHolder) viewHolder;
        countryViewHolder.textViewCountryName.setText(countryArrayList.get(i).getName());
        countryViewHolder.textViewCountryCapital.setText("Capital"+" "+countryArrayList.get(i).getCapital());


    }


    /**
     * method to return size of list
     *
     * @return studentArrayList size
     */
    @Override
    public int getItemCount() {
        return countryArrayList.size();
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder
    {
        TextView textViewCountryName;
        TextView textViewCountryCapital;

        /**
         * Student View Holder for CountryAdapter
         *
         * @param itemView
         *
         */
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCountryName = itemView.findViewById(R.id.item_country_view_tv_country_name);
            textViewCountryCapital = itemView.findViewById(R.id.item_country_view_tv_country_capital);

        }
    }

}
