package com.android.shoppingapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductViewHolder extends RecyclerView.ViewHolder{

    public View itemView;
    public Button add;
    public  Button remove;

    public ProductViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        add = itemView.findViewById(R.id.btnAdd);
        remove = itemView.findViewById(R.id.btnRemove);
    }

    public void setData(String name,int price,boolean isAdded){

        TextView tvName = itemView.findViewById(R.id.tvProductName);
        TextView tvPrice = itemView.findViewById(R.id.tvPrice);

        tvName.setText(name);
        tvPrice.setText(String.valueOf(price));

        if (isAdded){
            add.setVisibility(View.INVISIBLE);
            remove.setVisibility(View.VISIBLE);
        }
        else{
            remove.setVisibility(View.INVISIBLE);
            add.setVisibility(View.VISIBLE);
        }
    }
}
