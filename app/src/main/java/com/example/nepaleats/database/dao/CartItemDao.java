package com.example.nepaleats.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.nepaleats.database.models.CartItems;

import java.util.List;

@Dao
public interface CartItemDao {
    @Insert
    void insertItem(CartItems cartItem);

    @Delete
    void deleteCartItem(CartItems cartItem);

    @Query("DELETE FROM CartItems")
    void deleteAllCartItem();

    @Query("SELECT COUNT(*) From CartItems")
    int getItemCount();

    @Query("SELECT * From CartItems")
    List<CartItems> getAllItems();

    @Query("SELECT * From CartItems")
    LiveData<List<CartItems>> getAllItemsInCart();

    @Query("UPDATE CartItems SET qty = qty + 1, total_price = ( qty + 1 )* price WHERE item_id = :item_id ")
    void addQuantity(int item_id);

    @Query("UPDATE CartItems SET qty = qty - 1, total_price = ( qty - 1 )* price WHERE item_id = :itemID ")
    void minusQuantity(int itemID);

    @Update
    void updateItem(CartItems cartItem);

    @Query("SELECT * FROM CartItems WHERE item_id= :itemId LIMIT 1")
    CartItems getItemWithItemId(int itemId);
}


