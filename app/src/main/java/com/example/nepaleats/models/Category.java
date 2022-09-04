package com.example.nepaleats.models;

import java.util.ArrayList;

public class Category {
  private int id;
  private String name;
  private boolean is_category;
  private ArrayList<Food> food;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Food> getFood() {
        return food;
    }

    public void setFood(ArrayList<Food> food) {
        this.food = food;
    }

    public boolean isIs_category() {
        return is_category;
    }

    public void setIs_category(boolean is_category) {
        this.is_category = is_category;
    }
}

