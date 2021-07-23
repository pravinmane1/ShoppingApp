package com.android.shoppingapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.shoppingapp.entity.CartItem;
import com.android.shoppingapp.entity.Product;

import java.util.Collections;
import java.util.List;

public class ProductAdapter
        extends RecyclerView.Adapter<ProductViewHolder> {

    List<Product> list
            = Collections.emptyList();


    Context context;
    //ClickListiner listiner;

    public ProductAdapter(List<Product> list, Context context) {
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
        Product currentProduct = list.get(position);

        List<CartItem> i = db.cartDao().searchItemInCart(currentProduct.getProductId());
        if (i.size() != 0)
            isAdded = true;

        holder.setData(currentProduct.getProductName(), currentProduct.getPrice(),isAdded);

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.add.setVisibility(View.INVISIBLE);
                holder.remove.setVisibility(View.VISIBLE);

                CartItem item = new CartItem(currentProduct.getProductId(), currentProduct.getPrice(), currentProduct.getProductName());
                db.cartDao().insert(item);
            }
        });

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.add.setVisibility(View.VISIBLE);
                holder.remove.setVisibility(View.INVISIBLE);

                List<CartItem> item = db.cartDao().searchItemInCart(currentProduct.getProductId());

                if (item.size() != 0)
                    db.cartDao().delete(item.get(0));
            }
        });
    }

    @Override
    public int getItemCount() {

        if (list!=null)
        return list.size();

        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
