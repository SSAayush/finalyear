package com.example.nepaleats.models;

import java.io.Serializable;

// "id": 2,
//         "name": "Smoking Yk",
//         "address": "Niva Galli",
//         "contactno": "9806583976",
//         "delivery_time": "10",
//         "min_order": "200",
//         "opening_time": "12",
//         "closing_time": "1 Am",
//         "created_at": "2022-04-06T09:14:28.000000Z",
//         "updated_at": "2022-04-06T09:14:28.000000Z",
//         "status": "1"
public class Restaurant implements Serializable {
    private int id;
    private String name;
    private String address;
    private String contactno;
    private String delivery_time;
    private String min_order;
    private String opening_time;
    private String closing_time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    public String getMin_order() {
        return min_order;
    }

    public void setMin_order(String min_order) {
        this.min_order = min_order;
    }

    public String getOpening_time() {
        return opening_time;
    }

    public void setOpening_time(String opening_time) {
        this.opening_time = opening_time;
    }

    public String getClosing_time() {
        return closing_time;
    }

    public void setClosing_time(String closing_time) {
        this.closing_time = closing_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
