package com.android.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.shoppingapp.entity.CartItem;
import com.android.shoppingapp.entity.Product;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    CartDao cartDao;
    LiveData<List<CartItem>> cartItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        TextView checkout = findViewById(R.id.tvCart);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this,CheckoutActivity.class));
            }
        });

        ShoppingDatabase db = ShoppingDatabase.getDatabase(this);

        cartItems = db.cartDao().getCart();
        RecyclerView recyclerView
                = (RecyclerView)findViewById(
                R.id.products);




        cartItems.observe(this, new Observer<List<CartItem>>() {
            @Override
            public void onChanged(List<CartItem> cartItems) {

                CartAdapter adapter = new CartAdapter(cartItems,getApplicationContext());

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                int total =0;
                for(CartItem item:cartItems){
                    total= total+ item.getPrice();
                }

                checkout.setText("Total: "+total+" --checkout");
            }
        });
    }
}