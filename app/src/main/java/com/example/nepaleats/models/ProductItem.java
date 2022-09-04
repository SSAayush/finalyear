package com.example.nepaleats.models;

public class ProductItem {
    private int id;
    private String name;
    private String image;
//    private String description;
    private double price;
    private int qty;
    private int restaurant_id;

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
//    private double mrp_dollar;
//    private double final_selling_price;
//    private String type;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }



//    public double getMrp_dollar() {
//        return mrp_dollar;
//    }
//
//    public void setMrp_dollar(double mrp_dollar) {
//        this.mrp_dollar = mrp_dollar;
//    }
//
//    public double getFinal_selling_price() {
//        return final_selling_price;
//    }
//
//    public void setFinal_selling_price(double final_selling_price) {
//        this.final_selling_price = final_selling_price;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
}
