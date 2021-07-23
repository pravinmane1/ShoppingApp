package com.android.shoppingapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.android.shoppingapp.entity.CartItem;

import java.util.List;

@Dao
public interface CartDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(CartItem cartItem);

    @Query("SELECT * FROM CartItem")
    LiveData<List<CartItem>> getCart();

    @Query("select * from cartitem where itemId=:id")
    List<CartItem> searchItemInCart(int id);

    @Delete
    void delete(CartItem cartItem);

    @Query("delete from cartitem")
    void deleteAll();
}
