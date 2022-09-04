package com.example.nepaleats.response;

import com.example.nepaleats.models.UserInfo;

public class ResigsterResponse extends ResponseData{

    private UserInfo data;

    public UserInfo getData() {
        return data;
    }

    public void setData(UserInfo data) {
        this.data = data;
    }
}
