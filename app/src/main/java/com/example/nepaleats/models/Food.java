package com.example.nepaleats.models;
//    id": 2,
//            "name": "Non Veg",
//            "food": [
//            [
//    {
//        "id": 3,
//            "name": "Pizza",
//            "price": "Rs500",
//            "categories_id": 2,
//            "restaurant_id": 5,
//            "status": "1",
//            "created_at": "2022-04-12T09:11:11.000000Z",
//            "updated_at": "2022-04-12T09:11:11.000000Z"
//    }
//                ]
//                        ]

public class Food {
    private int id;
    private int categories_id;
    private int restaurant_id;
    private String name;
//    private double price;
    private String price;
    private String url;
//    private int qty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getQty() {
//        return qty;
//    }
//
//    public void setQty(int qty) {
//        this.qty = qty;
//    }

    public int getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(int categories_id) {
        this.categories_id = categories_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
}

