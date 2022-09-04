package com.example.nepaleats.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.nepaleats.api.ApiInterface;
import com.example.nepaleats.database.models.CartItems;
import com.example.nepaleats.repository.CartItemRepository;

import java.util.List;

public class CartViewModel extends AndroidViewModel {
    private LiveData<List<CartItems>> allItems;
    CartItemRepository repository;

    public CartViewModel(Application application) {
        super(application);
        repository = new CartItemRepository(application);
        allItems = repository.getAllItems();
    }

    public void insert(CartItems item) {
        repository.insertItem(item);
    }

    public LiveData<List<CartItems>> getAllItems() {
        return allItems;
    }

    public void addQuantity(CartItems item) {
        repository.addQuantity(item);
    }

    public void minusQuantity(CartItems item) {
        if (item.getQty() > 1) {
            repository.minusQuantity(item);
        }
        if (item.getQty() == 1) {
            removeItem(item);
        }
    }

    public void removeItem(CartItems item) {
        repository.delete(item);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

//    public void confirmOrder(ApiInterface apiInterface, List<CartItems> cartItems, final ConfirmOrderListener listener) {
//        repository.confirmOrder(apiInterface, cartItems, new CartItemRepository.ConfirmOrderListener() {
//            @Override
//            public void onResponse(ConfirmOrderResponse response) {
//                listener.onResponse(response);
//            }
//
//            @Override
//            public void onFailure(String errorMessage) {
//                listener.onFailure(errorMessage);
//            }
//        });
//    }
//
//    public interface ConfirmOrderListener {
//        void onResponse(ConfirmOrderResponse response);
//
//        void onFailure(String errorMessage);
//    }

}
