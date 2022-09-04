package com.example.nepaleats.api;

import com.example.nepaleats.models.OrderModel;
import com.example.nepaleats.response.CategoryResponse;
import com.example.nepaleats.response.ChangePasswordResponse;
import com.example.nepaleats.response.OrderResponse;
import com.example.nepaleats.response.ResigsterResponse;
import com.example.nepaleats.response.RestaurantResponse;
import com.example.nepaleats.response.SearchResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("api/register")
    Call<ResigsterResponse> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password

    );

    @FormUrlEncoded
    @POST("api/login")
    Call<ResigsterResponse> login(
            @Field("email") String email,
            @Field("password") String password

    );


    @GET("api/restaurant")
    Call<RestaurantResponse> getAllRestaurant(
    );


    @FormUrlEncoded
    @POST("api/category")
    Call<CategoryResponse> getAllCategory(
            @Field("restaurant_id") int restaurant_id
    );

    @FormUrlEncoded
    @POST("api/changePassword")
    Call<ChangePasswordResponse> changePassword(
            @Field("id") int id,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("api/search")
    Call<SearchResponse> search(
            @Field("search") String search
    );



//    @FormUrlEncoded
//    @POST("api/order_master")
//    Call<OrderMasterResponse> order(
//            @Field("data") String data
//    );

//    @FormUrlEncoded
    @POST("api/order")
    Call<OrderResponse> order(@Body OrderModel order_details);

}
