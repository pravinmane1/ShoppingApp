package com.android.shoppingapp.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {

    @PrimaryKey
            @ColumnInfo(name = "productId")
    int productId;

    @ColumnInfo(name = "price")
    int price;

    @ColumnInfo(name = "productName")
    String productName;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Product(int productId, int price, String productName) {
        this.productId = productId;
        this.price = price;
        this.productName = productName;
    }
}
