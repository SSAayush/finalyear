package com.example.nepaleats.models;

public class HomeModel {
    private int imgRestaurant;
    private String resName;
    private String resCity;
    private String resOrder;
    private String resPrice;
    private String resOpeningTime;
    private String resClosingTime;


    HomeModel(int imageRestaurant, String resName, String resCity, String resOrder, String resPrice, String resOpeningTime, String resClosingTime){
        this.imgRestaurant= imageRestaurant;
        this.resName=resName;
        this.resCity=resCity;
        this.resOrder=resOrder;
        this.resPrice=resPrice;
        this.resOpeningTime = resOpeningTime;
        this.resClosingTime = resClosingTime;


    }

    public int getImgRestaurant() {
        return imgRestaurant;
    }

    public String getResName() {
        return resName;
    }

    public String getResCity() {
        return resCity;
    }

    public String getResOrder() {
        return resOrder;
    }

    public String getResPrice() {
        return resPrice;
    }

    public String getResOpeningTime() {
        return resOpeningTime;
    }

    public String getResClosingTime() {
        return resClosingTime;
    }



}
