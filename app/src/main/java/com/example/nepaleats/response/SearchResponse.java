package com.example.nepaleats.response;

import com.example.nepaleats.models.Restaurant;

import java.util.ArrayList;

public class SearchResponse extends ResponseData{
    private ArrayList<Restaurant> data;

    public ArrayList<Restaurant> getData() {
        return data;
    }

    public void setData(ArrayList<Restaurant> data) {
        this.data = data;
    }
}
