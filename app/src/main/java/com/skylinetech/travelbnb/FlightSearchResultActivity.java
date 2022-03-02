package com.skylinetech.travelbnb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.skylinetech.travelbnb.adapters.CityAttractionsAdapter;
import com.skylinetech.travelbnb.adapters.FlightSearchResultAdapter;
import com.skylinetech.travelbnb.classes.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class FlightSearchResultActivity extends AppCompatActivity {

    RecyclerView rvFlightResults;
    FlightSearchResultAdapter flightSearchResultAdapter;

    List<Integer> FlightRes_image = new ArrayList<>();
    List<String> FlightRes_dep_time = new ArrayList<>();
    List<String> FlightRes_arr_time = new ArrayList<>();
    List<String> FlightRes_price = new ArrayList<>();
    List<String> FlightRes_flight_num = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_search_result);

        rvFlightResults = findViewById(R.id.rv_flights_search_results);

        //Result Recyclerview
        populateCityAttractionsList();
        flightSearchResultAdapter = new FlightSearchResultAdapter(FlightRes_image,FlightRes_dep_time,FlightRes_arr_time,FlightRes_price,FlightRes_flight_num, getApplicationContext());
        LinearLayoutManager attractionLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvFlightResults.setLayoutManager(attractionLayoutManager);
        rvFlightResults.setAdapter(flightSearchResultAdapter );
        rvFlightResults.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rvFlightResults,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        Intent intent = new Intent(getApplicationContext(), BookFlightActivity.class);
                        startActivity(intent);

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );


    }

    private void populateCityAttractionsList() {

        FlightRes_image.add(R.drawable.pia);
        FlightRes_image.add(R.drawable.turkishairlines);
        FlightRes_image.add(R.drawable.pia);
        FlightRes_image.add(R.drawable.emirates);
        FlightRes_image.add(R.drawable.qatarair);
        FlightRes_image.add(R.drawable.qatarair);
        FlightRes_image.add(R.drawable.lufthansa);
        FlightRes_image.add(R.drawable.turkishairlines);
        FlightRes_image.add(R.drawable.emirates);
        FlightRes_image.add(R.drawable.lufthansa);

        FlightRes_dep_time.add("9:00AM");
        FlightRes_dep_time.add("10:00AM");
        FlightRes_dep_time.add("12:00PM");
        FlightRes_dep_time.add("5:30AM");
        FlightRes_dep_time.add("8:50PM");
        FlightRes_dep_time.add("10:00PM");
        FlightRes_dep_time.add("3:00AM");
        FlightRes_dep_time.add("2:00PM");
        FlightRes_dep_time.add("7:30AM");
        FlightRes_dep_time.add("6:00AM");

        FlightRes_arr_time.add("7:00PM");
        FlightRes_arr_time.add("2:00AM");
        FlightRes_arr_time.add("3:00AM");
        FlightRes_arr_time.add("9:15AM");
        FlightRes_arr_time.add("6:00AM");
        FlightRes_arr_time.add("8:00AM");
        FlightRes_arr_time.add("3:30AM");
        FlightRes_arr_time.add("6:00AM");
        FlightRes_arr_time.add("1:00PM");
        FlightRes_arr_time.add("7:00AM");

        FlightRes_price.add("$193");
        FlightRes_price.add("$321");
        FlightRes_price.add("$123");
        FlightRes_price.add("$221");
        FlightRes_price.add("$176");
        FlightRes_price.add("$295");
        FlightRes_price.add("$244");
        FlightRes_price.add("$177");
        FlightRes_price.add("$377");
        FlightRes_price.add("$122");

        FlightRes_flight_num.add("PK104");
        FlightRes_flight_num.add("TA412");
        FlightRes_flight_num.add("PK443");
        FlightRes_flight_num.add("EA555");
        FlightRes_flight_num.add("QA224");
        FlightRes_flight_num.add("QA252");
        FlightRes_flight_num.add("LF099");
        FlightRes_flight_num.add("TA887");
        FlightRes_flight_num.add("EA966");
        FlightRes_flight_num.add("LF233");


    }
}