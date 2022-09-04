package com.example.nepaleats.response;

import com.example.nepaleats.models.Category;

import java.util.ArrayList;

public class CategoryResponse extends ResponseData {
    private ArrayList<Category> data;

    public ArrayList<Category> getData() {
        return data;
    }

    public void setData(ArrayList<Category> data) {
        this.data = data;
    }
}
