package com.skylinetech.travelbnb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.skylinetech.travelbnb.adapters.FlightSearchResultAdapter;
import com.skylinetech.travelbnb.adapters.HotelSearchResultAdapter;
import com.skylinetech.travelbnb.classes.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class HotelSearchResultsActivity extends AppCompatActivity{

    BottomSheetBehavior behavior,sortBehavior;
    RecyclerView rv_HotelResults;
    HotelSearchResultAdapter hotelSearchResultAdapter;

    List<Integer> HotelRes_image = new ArrayList<>();
    List<String> HotelRes_name = new ArrayList<>();
    List<Integer> HotelRes_starimage = new ArrayList<>();
    List<String> HotelRes_rating = new ArrayList<>();
    List<String> HotelRes_ratingstatus = new ArrayList<>();
    List<String> HotelRes_distance = new ArrayList<>();
    List<String> HotelRes_discprecent = new ArrayList<>();
    List<String> HotelRes_originalprice = new ArrayList<>();
    List<String> HotelRes_discountprice = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_search_results);

        rv_HotelResults = findViewById(R.id.rv_hotel_search_results);

        //Result Recyclerview
        populateHotelSearchResultList();
        hotelSearchResultAdapter = new HotelSearchResultAdapter(HotelRes_image,HotelRes_name,HotelRes_starimage,HotelRes_rating,HotelRes_ratingstatus,HotelRes_distance,HotelRes_discprecent,HotelRes_originalprice,HotelRes_discountprice, getApplicationContext());
        LinearLayoutManager attractionLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv_HotelResults.setLayoutManager(attractionLayoutManager);
        rv_HotelResults.setAdapter(hotelSearchResultAdapter );
        rv_HotelResults.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rv_HotelResults,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        Intent intent = new Intent(getApplicationContext(), BookHotelActivity.class);
                        startActivity(intent);

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        Button btnHotelfilter = (Button) findViewById(R.id.btn_Hotel_filter);
        Button btnFilterResult = (Button) findViewById(R.id.btn_filter_results);
        View bottomSheet = findViewById(R.id.bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);

        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                // React to state change
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // React to dragging events
            }
        });



        btnHotelfilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        btnFilterResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });


        Button btnHotelSort = (Button) findViewById(R.id.btn_Hotel_Sort);
        Button btnSortResult = (Button) findViewById(R.id.btn_sort_results);
        View SortbottomSheet = findViewById(R.id.sort_bottom_sheet);
        sortBehavior = BottomSheetBehavior.from(SortbottomSheet);

        sortBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                // React to state change
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // React to dragging events
            }
        });



        btnHotelSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        btnSortResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

    }

    private void populateHotelSearchResultList() {

        HotelRes_image.add(R.drawable.h11);
        HotelRes_image.add(R.drawable.h21);
        HotelRes_image.add(R.drawable.h31);
        HotelRes_image.add(R.drawable.h41);
        HotelRes_image.add(R.drawable.h51);

        HotelRes_name.add("Monti Palace Hotel");
        HotelRes_name.add("Hilton Garden Inn");
        HotelRes_name.add("The Hive Hotel");
        HotelRes_name.add("Hotel Caravel");
        HotelRes_name.add("Welcome Piram Hotel");

        HotelRes_starimage.add(R.drawable.fourstar);
        HotelRes_starimage.add(R.drawable.fourstar);
        HotelRes_starimage.add(R.drawable.fivestar);
        HotelRes_starimage.add(R.drawable.fourstar);
        HotelRes_starimage.add(R.drawable.fivestar);

        HotelRes_rating.add("4.5");
        HotelRes_rating.add("4.8");
        HotelRes_rating.add("4.3");
        HotelRes_rating.add("4.6");
        HotelRes_rating.add("4.9");

        HotelRes_ratingstatus.add("Very Good");
        HotelRes_ratingstatus.add("Excellent");
        HotelRes_ratingstatus.add("Good");
        HotelRes_ratingstatus.add("Very Good");
        HotelRes_ratingstatus.add("Excellent");

        HotelRes_distance.add("2.1 km");
        HotelRes_distance.add("1.2 km");
        HotelRes_distance.add("3.4 km");
        HotelRes_distance.add("6.2 km");
        HotelRes_distance.add("4.2 km");

        HotelRes_discprecent.add("20%");
        HotelRes_discprecent.add("12%");
        HotelRes_discprecent.add("15%");
        HotelRes_discprecent.add("22%");
        HotelRes_discprecent.add("10%");

        HotelRes_originalprice.add("$115");
        HotelRes_originalprice.add("$130");
        HotelRes_originalprice.add("$145");
        HotelRes_originalprice.add("$169");
        HotelRes_originalprice.add("$126");

        HotelRes_discountprice.add("$70");
        HotelRes_discountprice.add("$105");
        HotelRes_discountprice.add("$110");
        HotelRes_discountprice.add("$145");
        HotelRes_discountprice.add("$115");

    }
}