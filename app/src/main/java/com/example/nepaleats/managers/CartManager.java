package com.example.nepaleats.managers;

import android.content.Context;

import com.example.nepaleats.database.models.CartItems;
import com.example.nepaleats.models.ProductItem;
import com.example.nepaleats.repository.CartItemRepository;

public class CartManager {
    CartItemRepository repository;
    Context context;

    public CartManager(Context context) {
        this.context = context;
        this.repository = new CartItemRepository(context);
    }

    public static void addToCart(Context context, ProductItem item) {

        CartItems cartItem = new CartItems();
        cartItem.setName(item.getName());
        cartItem.setPrice(item.getPrice());
        cartItem.setQty(1);

        double totalPrice= (cartItem.getPrice()*cartItem.getQty());
//        double totalPrice = item.getPrice();
        cartItem.setTotal_price(totalPrice);
        cartItem.setPrice(item.getPrice());
        cartItem.setItem_id(item.getId());
        new CartItemRepository(context).insertItem(cartItem);

    }

//    public static void addToCart(Context context, ProductPackage item, String productType) {
//
//
//
//        CartItems cartItem = new CartItems();
//        cartItem.setName(item.getPackageName());
//        cartItem.setPrice(item.getFinal_selling_price());
//        cartItem.setQty(1);
//        double totalPrice = item.getFinal_selling_price();
//        cartItem.setTotal_price(totalPrice);
//        cartItem.setItem_id(Integer.parseInt(item.getId()));
//        cartItem.setType(productType);
//        new CartItemRepository(context).insertItem(cartItem);
//
//    }

    public static void removeFromCart(ProductItem item) {

    }

    public static void addQuantity(Context context, CartItems item) {
        /*new CartItemRepository(context).addQuantity(item.getItem_id(), item.getType());*/
    }

    public static void reduceQuantity(ProductItem item) {
    }

}
