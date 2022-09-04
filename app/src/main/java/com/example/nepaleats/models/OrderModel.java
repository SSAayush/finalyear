package com.example.nepaleats.models;

import com.example.nepaleats.database.models.CartItems;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class OrderModel implements Serializable {

  int user_id;
  int restaurant_id;
  double total;
  String address_details;

  @SerializedName("order_details")
  private List<CartItems> orderDetails;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getAddress_details() {
        return address_details;
    }

    public void setAddress_details(String address_details) {
        this.address_details = address_details;
    }

    public List<CartItems> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<CartItems> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
