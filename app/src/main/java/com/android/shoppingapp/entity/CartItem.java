package com.android.shoppingapp.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CartItem {

    @PrimaryKey
    @ColumnInfo(name = "itemId")
    private int itemId;

    @ColumnInfo(name = "price")
    private int price;

    @ColumnInfo(name = "productName")
    private String productName;

    public CartItem(int itemId, int price, String productName) {
        this.itemId = itemId;
        this.price = price;

        this.productName = productName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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
}
