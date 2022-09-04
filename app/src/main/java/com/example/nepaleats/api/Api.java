package com.example.nepaleats.api;

public class Api {

//   public static final String Base_URL ="http://192.168.1.5/nepaleats-app/public/";
//    public static final String Base_URL ="http://192.168.1.78/nepaleats-app/public/";
    public static final String Base_URL ="https://nepaleats.akshara.com.np/";

//    public static final String Base_URL= "http://10.0.2.2:8000/";

//    public static final String Base_URL ="http://localhost/nepaleats-app/public/";

    public static String getImageFromUrl(String url){
        return String.format("%s%s",Base_URL,url);
    }

}
