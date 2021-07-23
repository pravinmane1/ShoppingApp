package com.android.shoppingapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.android.shoppingapp.entity.CartItem;
import com.android.shoppingapp.entity.Product;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Product product);

    @Query("SELECT * FROM Product")
    LiveData<List<Product>> getProducts();
}

