package com.android.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Button checkout = findViewById(R.id.btnCheckout);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new AlertDialog.Builder(CheckoutActivity.this)
                        .setTitle("Checkout confirmation")
                        .setMessage("Please confirm the payment.")
                        .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ShoppingDatabase db = ShoppingDatabase.getDatabase(getApplicationContext());
                                db.cartDao().deleteAll();
                                finish();
                            }
                        })
                        .setNegativeButton("Failed", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });
    }
}