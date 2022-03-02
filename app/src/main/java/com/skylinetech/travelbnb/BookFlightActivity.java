package com.skylinetech.travelbnb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BookFlightActivity extends AppCompatActivity {

    Button btnFlightCheckout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_flight);

        btnFlightCheckout = findViewById(R.id.btn_flight_checkout);

        btnFlightCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CheckoutActivity.class));
            }
        });
    }
}