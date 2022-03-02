package com.skylinetech.travelbnb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.skylinetech.travelbnb.adapters.ToursRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TripsActivity extends AppCompatActivity {

    RecyclerView rvTrips;
    List<String> total_reviews_lists = new ArrayList<>();
    List<String> tour_ratings_lists = new ArrayList<>();
    List<String> tour_name_lists = new ArrayList<>();
    List<String> tour_cost_lists = new ArrayList<>();
    List<Integer> tour_image_lists = new ArrayList<>();
    ToursRecyclerAdapter CitytoursAdapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);

        rvTrips = findViewById(R.id.rv_trip);
        //tours recyclerview
        populateCityToursLists();
        CitytoursAdapater = new ToursRecyclerAdapter(tour_name_lists,tour_image_lists,tour_ratings_lists,total_reviews_lists, tour_cost_lists, getApplicationContext());
        LinearLayoutManager toursLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvTrips.setLayoutManager(toursLayoutManager);
        rvTrips.setAdapter(CitytoursAdapater );
    }

    private void populateCityToursLists() {

        tour_name_lists.add("Rome City Center Highlights by Electric-assist bicycle");
        tour_name_lists.add("Rome Colosseum, Roman Forum and Palatine Hill Fast-Track Tour");
        tour_name_lists.add("Rome Segway Night Tour");
        tour_name_lists.add("The Roman Empire Museum (Capitolini) Ticket");

        tour_image_lists.add(R.drawable.ctt1);
        tour_image_lists.add(R.drawable.ctt2);
        tour_image_lists.add(R.drawable.ctt3);
        tour_image_lists.add(R.drawable.ctt4);

        tour_ratings_lists.add("5");
        tour_ratings_lists.add("4.5");
        tour_ratings_lists.add("4");
        tour_ratings_lists.add("5");

        total_reviews_lists.add("799 reviews");
        total_reviews_lists.add("86 reviews");
        total_reviews_lists.add("125 reviews");
        total_reviews_lists.add("239 reviews");

        tour_cost_lists.add("$49.00");
        tour_cost_lists.add("$30.00");
        tour_cost_lists.add("$120.00");
        tour_cost_lists.add("$99.00");

    }


}