package com.android.shoppingapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.shoppingapp.entity.CartItem;
import com.android.shoppingapp.entity.CartItem;

import java.util.Collections;
import java.util.List;

public class CartAdapter
        extends RecyclerView.Adapter<ProductViewHolder> {

    List<CartItem> list
            = Collections.emptyList();

    Context context;
    //ClickListiner listiner;

    public CartAdapter(List<CartItem> list, Context context) {
        this.list = list;
        this.context = context;

    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater
                = LayoutInflater.from(parent.getContext());

        // Inflate the layout

        View productView
                = inflater
                .inflate(R.layout.product_item,
                        parent, false);

        ProductViewHolder viewHolder
                = new ProductViewHolder(productView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        boolean isAdded = false;

        ShoppingDatabase db = ShoppingDatabase.getDatabase(context);
        CartItem currentItem = list.get(position);


        holder.setData(currentItem.getProductName(), currentItem.getPrice(), true);


        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                List<CartItem> item = db.cartDao().searchItemInCart(currentItem.getItemId());

                if (item.size() != 0)
                    db.cartDao().delete(item.get(0));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
