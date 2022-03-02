package com.skylinetech.travelbnb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.skylinetech.travelbnb.adapters.CarRentalSearchResultAdapter;
import com.skylinetech.travelbnb.adapters.HotelSearchResultAdapter;
import com.skylinetech.travelbnb.classes.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class CarSearchResultActivity extends AppCompatActivity {

    RecyclerView rv_CarRentals;
    CarRentalSearchResultAdapter carRentalSearchResultAdapter;

    List<Integer> CarRental_carimage = new ArrayList<>();
    List<String> CarRental_type = new ArrayList<>();
    List<String> CarRental_name = new ArrayList<>();
    List<Integer> CarRental_companyimage = new ArrayList<>();
    List<String> CarRental_capacity = new ArrayList<>();
    List<String> CarRental_geartype = new ArrayList<>();
    List<String> CarRental_price = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_search_result);

        rv_CarRentals = findViewById(R.id.rv_car_rentals_search_results);

        //Result Recyclerview
        populateCarSearchResultList();
        carRentalSearchResultAdapter = new CarRentalSearchResultAdapter(CarRental_carimage,CarRental_type,CarRental_name,CarRental_companyimage,CarRental_capacity,CarRental_geartype,CarRental_price, getApplicationContext());
        LinearLayoutManager attractionLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv_CarRentals.setLayoutManager(attractionLayoutManager);
        rv_CarRentals.setAdapter(carRentalSearchResultAdapter );
        /*rv_CarRentals.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rv_CarRentals,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        Intent intent = new Intent(getApplicationContext(), BookHotelActivity.class);
                        startActivity(intent);

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

         */


    }

    private void populateCarSearchResultList() {

        CarRental_carimage.add(R.drawable.car1);
        CarRental_carimage.add(R.drawable.car2);
        CarRental_carimage.add(R.drawable.car3);
        CarRental_carimage.add(R.drawable.car4);

        CarRental_type.add("Mini");
        CarRental_type.add("Compact");
        CarRental_type.add("SUV");
        CarRental_type.add("Luxury");

        CarRental_companyimage.add(R.drawable.crc1);
        CarRental_companyimage.add(R.drawable.crc2);
        CarRental_companyimage.add(R.drawable.crc3);
        CarRental_companyimage.add(R.drawable.crc4);

        CarRental_name.add("Toyota Yaris or Similar");
        CarRental_name.add("Toyota Camry or Similar");
        CarRental_name.add("Jeep Wrangler 4 or Similar");
        CarRental_name.add("Benz C-Class or Similar");

        CarRental_capacity.add("4");
        CarRental_capacity.add("5");
        CarRental_capacity.add("5");
        CarRental_capacity.add("5");

        CarRental_geartype.add("Manual");
        CarRental_geartype.add("Automatic");
        CarRental_geartype.add("Manual");
        CarRental_geartype.add("Automatic");

        CarRental_price.add("$34");
        CarRental_price.add("$56");
        CarRental_price.add("$84");
        CarRental_price.add("$169");


    }
}