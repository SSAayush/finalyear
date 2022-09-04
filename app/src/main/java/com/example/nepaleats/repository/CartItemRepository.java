package com.example.nepaleats.repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.nepaleats.api.ApiInterface;
import com.example.nepaleats.database.AppDatabase;
import com.example.nepaleats.database.dao.CartItemDao;
import com.example.nepaleats.database.models.CartItems;

import java.util.List;

public class CartItemRepository {
    private Context context;
    private CartItemDao dao;
    private LiveData<List<CartItems>> allRecords;
//    private ConfirmOrderListener listener;

    public CartItemRepository(Context context) {
        this.context = context;
        AppDatabase database = AppDatabase.getInstance(context);
        dao = database.dao();
        allRecords = dao.getAllItemsInCart();
    }

    //Basic operation

    public void insertItem(CartItems item) {

        new CartItemRepository.InsertItemAsyncTask(dao).execute(item);
    }

    public void delete(CartItems item) {
        new CartItemRepository.DeleteItemAsyncTask(dao).execute(item);
    }

    public void addQuantity(CartItems item) {
        new CartItemRepository.AddQuantityAsyncTask(dao, item.getItem_id(), item.getType()).execute();
    }

    public void minusQuantity(CartItems item) {
        new CartItemRepository.MinusQuantityAsyncTask(dao, item.getItem_id(), item.getType()).execute();
    }

    public void update(CartItems item) {
        new CartItemRepository.UpdateItemAsyncTask(dao).execute(item);
    }

    public void deleteAll() {
        new CartItemRepository.DeleteAllItemAsyncTask(dao).execute();
    }

    public LiveData<List<CartItems>> getAllItems() {
        return allRecords;
    }

//    public LiveData<CartItem> getCartItemByItemKeyLive(long item_key) {
//
//        return dao.getCartItemByKey(item_key);
//    }

//    public void updateCartItemQtyByItemKey(long itemKey, int qty) {
//        CartUpdateValues cartUpdateValues = new CartUpdateValues();
//        cartUpdateValues.setItemKey(itemKey);
//        cartUpdateValues.setQty(qty);
//        new UpdateCartItemQtyByItemKeyAsyncTask(dao).execute(cartUpdateValues);
//    }

    //Network methods
//    public void confirmOrder(ApiInterface apiInterface, List<CartItems> cartItems, final ConfirmOrderListener listener) {
//        this.listener = listener;
////        String token = PrefsManager.getUserToken();
//
//        if (token != null) {
//            if (!token.isEmpty()) {
//                String username = PrefsManager.getCustInfo().getUsername();
//                Order order = new Order();
//                order.setToken(token);
//                order.setUsername(username);
//                order.setOrderItems(cartItems);
//                order.setShippingDetails(PrefsManager.getShippingDetails());
//
//                Call<ConfirmOrderResponse> call = apiInterface.postOrder(order);
//                call.enqueue(new Callback<ConfirmOrderResponse>() {
//                    @Override
//                    public void onResponse(Call<ConfirmOrderResponse> call, Response<ConfirmOrderResponse> response) {
//                        if (listener != null) {
//                            listener.onResponse(response.body());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ConfirmOrderResponse> call, Throwable t) {
//                        if (listener != null) {
//                            listener.onFailure(t.getMessage());
//                        }
//                    }
//                });
//            } else {
//                listener.onFailure("401");
//            }
//        } else {
//            listener.onFailure("401");
//        }
//    }

    private static class InsertItemAsyncTask extends AsyncTask<CartItems, Void, Void> {
        private CartItemDao dao;

        public InsertItemAsyncTask(CartItemDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CartItems... cartItems) {
            int itemId = cartItems[0].getItem_id();
            CartItems item = dao.getItemWithItemId(itemId);

            if (item != null) {
                dao.addQuantity(itemId);
            } else {
                dao.insertItem(cartItems[0]);
            }
            return null;
        }
    }

    private static class UpdateItemAsyncTask extends AsyncTask<CartItems, Void, Void> {
        private CartItemDao dao;

        public UpdateItemAsyncTask(CartItemDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CartItems... cartItems) {
            dao.updateItem(cartItems[0]);
            return null;
        }
    }

    private static class DeleteItemAsyncTask extends AsyncTask<CartItems, Void, Void> {
        private CartItemDao dao;

        public DeleteItemAsyncTask(CartItemDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CartItems... cartItems) {
            dao.deleteCartItem(cartItems[0]);
            return null;
        }
    }

    private static class DeleteAllItemAsyncTask extends AsyncTask<Void, Void, Void> {

        private CartItemDao dao;

        public DeleteAllItemAsyncTask(CartItemDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllCartItem();
            return null;
        }
    }

    private static class AddQuantityAsyncTask extends AsyncTask<CartItems, Void, Void> {

        private CartItemDao dao;
        private int itemId;
        private String type;

        public AddQuantityAsyncTask(CartItemDao dao, int itemId, String type) {
            this.dao = dao;
            this.itemId = itemId;
            this.type = type;
        }

        @Override
        protected Void doInBackground(CartItems... cartItems) {
            Log.d("sugam", "Item id =>" + itemId);

            dao.addQuantity(itemId);
            return null;
        }
    }

    private static class MinusQuantityAsyncTask extends AsyncTask<Void, Void, Void> {

        private CartItemDao dao;
        private int itemId;
        private String type;

        public MinusQuantityAsyncTask(CartItemDao dao, int id, String type) {
            this.itemId = id;
            this.dao = dao;
            this.type = type;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            Log.d("sugam", "Inside doInBackground" + itemId);
            dao.minusQuantity(itemId);
            return null;
        }
    }

/*    public interface ConfirmOrderListener {
        void onResponse(ConfirmOrderResponse response);

        void onFailure(String errorMessage);
    }*/

   /* private class UpdateCartItemQtyByItemKeyAsyncTask extends AsyncTask<CartUpdateValues, Void, Void> {
        private CartItemDao dao;

        public UpdateCartItemQtyByItemKeyAsyncTask(CartItemDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CartUpdateValues... cartUpdateValues) {
            dao.updateCartItemQtyByItemKey(cartUpdateValues[0].getItemKey(), cartUpdateValues[0].getQty());
            return null;
        }
    }*/

//    public interface ConfirmOrderListener {
//        void onResponse(ConfirmOrderResponse response);
//
//        void onFailure(String errorMessage);
//    }
}
