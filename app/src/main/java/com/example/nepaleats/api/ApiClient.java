package com.example.nepaleats.api;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit == null) {
            Log.d("aayush", "Retrofit is null building retrofit");


//          http://ebtech.dyndns.org:3048/CRONUS/OData/Company('CRONUSLS90008W1')/Staff_list?$filter=ID%20eq%20%27601%27&$format=json
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
//                    .authenticator(new NTLMAuthenticator("test1", "Ebt@123", "http://ebtech.dyndns.org:3048/CRONUS/OData/Company('CRONUSLS90008W1')/Staff_lis&$format=json"))
                    .cache(null)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Api.Base_URL)
//                    .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(new Persister(new AnnotationStrategy())))
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit;
        } else {
            return retrofit;
        }
    }
}
