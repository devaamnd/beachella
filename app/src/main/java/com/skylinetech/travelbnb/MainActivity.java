package com.skylinetech.travelbnb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.skylinetech.travelbnb.adapters.AttractionsAdapter;
import com.skylinetech.travelbnb.adapters.DealsAdapter;
import com.skylinetech.travelbnb.adapters.HotelSearchResultAdapter;
import com.skylinetech.travelbnb.adapters.HotelsForYouRecyclerAdapter;
import com.skylinetech.travelbnb.adapters.PlacesForYouRecyclerAdapter;
import com.skylinetech.travelbnb.adapters.StoriesMainAdapter;
import com.skylinetech.travelbnb.adapters.ToursRecyclerAdapter;
import com.skylinetech.travelbnb.classes.RecyclerClass;
import com.skylinetech.travelbnb.classes.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvPlacesForYou,rvDiscountDeals,rvAttractions, rvStories,rv_Hotels,rv_Trips;
    PlacesForYouRecyclerAdapter placesForYouRecyclerAdapter;
    AttractionsAdapter AttractionAdapter;
    DealsAdapter DealsAdapter;
    StoriesMainAdapter storiesMainAdapter;
    List<RecyclerClass> placesforyourecyclerList = new ArrayList<>();
    List<RecyclerClass> attractionsList = new ArrayList<>();
    List<Integer> dealsList = new ArrayList<>();
    List<Integer> UimageList = new ArrayList<>();
    List<String> UnameList = new ArrayList<>();
    ImageButton btnFlights,btnHotels,btnCarRentals,btnNotifications;

    List<String> Price = new ArrayList<>();
    HotelsForYouRecyclerAdapter hotelsForYouRecyclerAdapter;
    List<RecyclerClass> hotelsforyourecyclerList = new ArrayList<>();

    List<String> total_reviews_lists = new ArrayList<>();
    List<String> tour_ratings_lists = new ArrayList<>();
    List<String> tour_name_lists = new ArrayList<>();
    List<String> tour_cost_lists = new ArrayList<>();
    List<Integer> tour_image_lists = new ArrayList<>();
    ToursRecyclerAdapter CitytoursAdapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPlacesForYou = findViewById(R.id.rv_places_for_you);
        rvDiscountDeals = findViewById(R.id.rv_discount_deals);
        rvAttractions = findViewById(R.id.rv_attractions);
        rvStories = findViewById(R.id.rv_stories);
        btnFlights = findViewById(R.id.main_btn_flights);
        btnCarRentals = findViewById(R.id.main_btn_rentals);
        btnHotels = findViewById(R.id.main_btn_hotels);
        rv_Hotels = findViewById(R.id.rv__main_hotels);
        rv_Trips = findViewById(R.id.rv__main_trips);
        btnNotifications = findViewById(R.id.btn_notification);


        btnFlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FlightSearchActivity.class));
            }
        });

        btnHotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HotelSearchActivity.class));
            }
        });

        btnCarRentals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CarRentSearchActivity.class));
            }
        });

        btnNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),NotificationActivity.class));
            }
        });

        placesForYouRecyclerAdapter = new PlacesForYouRecyclerAdapter(placesforyourecyclerList, getApplicationContext());
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rvPlacesForYou.setLayoutManager(horizontalLayoutManager);
        rvPlacesForYou.setAdapter(placesForYouRecyclerAdapter );
        populatePlacesList();
        rvPlacesForYou.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rvPlacesForYou,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        String namess = placesforyourecyclerList.get(position).getPlaceName();
                        Intent intent = new Intent(getApplicationContext(), CityDetailsActivity.class);
                        intent.putExtra("detail", namess);
                        startActivity(intent);

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        AttractionAdapter = new AttractionsAdapter(attractionsList, getApplicationContext());
        LinearLayoutManager attractionLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rvAttractions.setLayoutManager(attractionLayoutManager);
        rvAttractions.setAdapter(AttractionAdapter );
        populateAttractionsList();
        rvAttractions.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rvAttractions,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        Intent intent = new Intent(getApplicationContext(), PlaceDetailsActivity.class);
                        startActivity(intent);

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );


        DealsAdapter = new DealsAdapter(dealsList, getApplicationContext());
        LinearLayoutManager dealsLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rvDiscountDeals.setLayoutManager(dealsLayoutManager);
        rvDiscountDeals.setAdapter(DealsAdapter );
        populateDealsList();
        rvDiscountDeals.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rvDiscountDeals,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        Intent intent = new Intent(getApplicationContext(), PlaceDetailsActivity.class);
                        startActivity(intent);

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        storiesMainAdapter = new StoriesMainAdapter(UimageList,UnameList, getApplicationContext());
        LinearLayoutManager storiesLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rvStories.setLayoutManager(storiesLayoutManager);
        rvStories.setAdapter(storiesMainAdapter );
        populateStoriesList();
        rvStories.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rvStories,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        Intent intent = new Intent(getApplicationContext(), StoriesActivity.class);
                        startActivity(intent);

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );



        //Result Recyclerview
        populateHotelsList();
        hotelsForYouRecyclerAdapter = new HotelsForYouRecyclerAdapter(hotelsforyourecyclerList,Price, getApplicationContext());
        StaggeredGridLayoutManager hotelsLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rv_Hotels.setLayoutManager(hotelsLayoutManager);
        rv_Hotels.setAdapter(hotelsForYouRecyclerAdapter );
        rv_Hotels.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rv_Hotels,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        Intent intent = new Intent(getApplicationContext(), BookHotelActivity.class);
                        startActivity(intent);

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        //tours recyclerview
        populateCityToursLists();
        CitytoursAdapater = new ToursRecyclerAdapter(tour_name_lists,tour_image_lists,tour_ratings_lists,total_reviews_lists, tour_cost_lists, getApplicationContext());
        LinearLayoutManager toursLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rv_Trips.setLayoutManager(toursLayoutManager);
        rv_Trips.setAdapter(CitytoursAdapater );

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

    private void populateHotelsList() {

        RecyclerClass Monti = new RecyclerClass("Monti Palace Hotel", "London",R.drawable.h11);
        RecyclerClass Hilton = new RecyclerClass("Hilton Garden Inn","Birmingham", R.drawable.h21);
        RecyclerClass Hive = new RecyclerClass("The Hive Hotel","London", R.drawable.h31);
        RecyclerClass Caravel = new RecyclerClass("Hotel Caravel","Manchester", R.drawable.h41);
        RecyclerClass WelcomePiramHotel = new RecyclerClass("Welcome Piram Hotel","Liverpool", R.drawable.h51);
        hotelsforyourecyclerList.add(Monti);
        hotelsforyourecyclerList.add(Hilton);
        hotelsforyourecyclerList.add(Hive);
        hotelsforyourecyclerList.add(Caravel);
        hotelsforyourecyclerList.add(WelcomePiramHotel);
        //hotelsForYouRecyclerAdapter.notifyDataSetChanged();

        Price.add("$70");
        Price.add("$105");
        Price.add("$110");
        Price.add("$145");
        Price.add("$115");

    }

    private void populateStoriesList() {

        UimageList.add(R.drawable.rv1);
        UimageList.add(R.drawable.rv3);
        UimageList.add(R.drawable.rv8);
        UimageList.add(R.drawable.rv6);
        UimageList.add(R.drawable.rv7);

        UnameList.add("Paul Smith");
        UnameList.add("Sam Bills");
        UnameList.add("Alex Benz");
        UnameList.add("Mike Pence");
        UnameList.add("Joe Morgan");
    }

    private void populateAttractionsList() {

        RecyclerClass Pyramid = new RecyclerClass("Great Pyramid of Giza", "Egypt",R.drawable.a1);
        RecyclerClass Opera = new RecyclerClass("Sydney Opera House","Australia", R.drawable.a2);
        RecyclerClass BlueMosque = new RecyclerClass("Blue Mosque","Singapore", R.drawable.a3);
        RecyclerClass Petra = new RecyclerClass("Petra","Jordan", R.drawable.a4);
        RecyclerClass Wall = new RecyclerClass("Great Wall of China","China", R.drawable.a5);
        RecyclerClass Niagara = new RecyclerClass("Niagara Falls","Canada", R.drawable.a6);
        attractionsList.add(Pyramid);
        attractionsList.add(Opera);
        attractionsList.add(BlueMosque);
        attractionsList.add(Petra);
        attractionsList.add(Wall);
        attractionsList.add(Niagara);
        AttractionAdapter.notifyDataSetChanged();

    }


    private void populateDealsList() {
        dealsList.add(R.drawable.b1);
        dealsList.add(R.drawable.b2);
        dealsList.add(R.drawable.b3);
        dealsList.add(R.drawable.b4);
    }

    private void populatePlacesList() {

        RecyclerClass Dubai = new RecyclerClass("Dubai", "UAE",R.drawable.dubai);
        RecyclerClass Istanbul = new RecyclerClass("Istanbul","Turkey", R.drawable.istanbul);
        RecyclerClass Singapore = new RecyclerClass("Singapore","Singapore", R.drawable.singapore);
        RecyclerClass KaulaLumpur = new RecyclerClass("Kaula Lumpur","Malaysia", R.drawable.kaula);
        RecyclerClass NewYork = new RecyclerClass("New York","USA", R.drawable.newyork);
        RecyclerClass London = new RecyclerClass("London","England", R.drawable.london);
        RecyclerClass Bangkok = new RecyclerClass("Bangkok","Thailand", R.drawable.bangkok);
        placesforyourecyclerList.add(Dubai);
        placesforyourecyclerList.add(Istanbul);
        placesforyourecyclerList.add(Singapore);
        placesforyourecyclerList.add(KaulaLumpur);
        placesforyourecyclerList.add(NewYork);
        placesforyourecyclerList.add(London);
        placesforyourecyclerList.add(Bangkok);
        placesForYouRecyclerAdapter.notifyDataSetChanged();

    }

    public void OnClickBtn(View view) {
        int id = view.getId();

        if (id == R.id.lythome) {
            finish();
            startActivity(new Intent(MainActivity.this, MainActivity.class));

        } else if (id == R.id.lyttrips) {
            startActivity(new Intent(MainActivity.this, TripsActivity.class));
        } else if (id == R.id.lytstays) {

            startActivity(new Intent(MainActivity.this, HotelSearchActivity.class));
        } else if (id == R.id.lytfav) {
           startActivity(new Intent(MainActivity.this, FavoritesActivity.class));
        } else if (id == R.id.lytprofile) {
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }
    }
}