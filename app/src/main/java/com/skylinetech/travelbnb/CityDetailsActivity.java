package com.skylinetech.travelbnb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.skylinetech.travelbnb.adapters.AttractionsAdapter;
import com.skylinetech.travelbnb.adapters.CityAttractionsAdapter;
import com.skylinetech.travelbnb.adapters.DetailsViewpagerAdapter;
import com.skylinetech.travelbnb.adapters.HotelsAdapter;
import com.skylinetech.travelbnb.adapters.NearbyDestinationsAdapter;
import com.skylinetech.travelbnb.adapters.ToursRecyclerAdapter;
import com.skylinetech.travelbnb.classes.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class CityDetailsActivity extends AppCompatActivity {

    ViewPager vpCityDetailImages;
    RecyclerView rv_attractions,rv_Ctours,rv_Chotels,rv_NearbyDest;
    DetailsViewpagerAdapter CitydetailsViewpagerAdapter;
    ToursRecyclerAdapter CitytoursAdapater;
    HotelsAdapter CityhotelsAdapter;
    NearbyDestinationsAdapter CitynearbydestAdapter;
    CityAttractionsAdapter cityAttractionsAdapter;
    List<Integer> images = new ArrayList<Integer>();

    List<Integer> Att_Aimage = new ArrayList<>();
    List<String> Att_Atitle = new ArrayList<>();
    List<String> Att_Atiming = new ArrayList<>();
    List<String> Att_Adistance = new ArrayList<>();
    List<String> Att_Arating = new ArrayList<>();
    List<String> Att_Asite = new ArrayList<>();

    List<Integer> Nearby_image = new ArrayList<>();
    List<String> Nearby_title = new ArrayList<>();
    List<String> Nearby_distance = new ArrayList<>();

    List<String> total_reviews_lists = new ArrayList<>();
    List<String> tour_ratings_lists = new ArrayList<>();
    List<String> tour_name_lists = new ArrayList<>();
    List<String> tour_cost_lists = new ArrayList<>();
    List<Integer> tour_image_lists = new ArrayList<>();

    List<String> hotel_total_reviews_lists = new ArrayList<>();
    List<String> hotel_ratings_lists = new ArrayList<>();
    List<String> hotel_name_lists = new ArrayList<>();
    List<String> hotel_cost_lists = new ArrayList<>();
    List<String> hotel_distance_lists = new ArrayList<>();
    List<Integer> hotel_image_lists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_details);

        vpCityDetailImages = findViewById(R.id.vp_city_details_images);
        rv_attractions = findViewById(R.id.city_details_attractions);
        rv_Ctours = findViewById(R.id.city_details_tours);
        rv_Chotels = findViewById(R.id.city_details_hotels);
        rv_NearbyDest = findViewById(R.id.city_details_nearby_destinations);

        //Image Slider
        populatedetailssliderimages();
        CitydetailsViewpagerAdapter = new DetailsViewpagerAdapter(getApplicationContext(),images);
        vpCityDetailImages.setAdapter(CitydetailsViewpagerAdapter);

        //Attraction Recyclerview
        cityAttractionsAdapter = new CityAttractionsAdapter(Att_Aimage,Att_Atitle,Att_Atiming,Att_Adistance,Att_Arating,Att_Asite, getApplicationContext());
        LinearLayoutManager attractionLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rv_attractions.setLayoutManager(attractionLayoutManager);
        rv_attractions.setAdapter(cityAttractionsAdapter );
        populateCityAttractionsList();
        rv_attractions.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), rv_attractions,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                       // Intent intent = new Intent(getApplicationContext(), PlaceDetailsActivity.class);
                       // startActivity(intent);

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
        rv_Ctours.setLayoutManager(toursLayoutManager);
        rv_Ctours.setAdapter(CitytoursAdapater );

        //hotels recyclerview
        populateHotelsLists();
        CityhotelsAdapter = new HotelsAdapter(hotel_name_lists,hotel_image_lists,hotel_ratings_lists,hotel_total_reviews_lists, hotel_cost_lists,hotel_distance_lists, getApplicationContext());
        LinearLayoutManager hotelsLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv_Chotels.setLayoutManager(hotelsLayoutManager);
        rv_Chotels.setAdapter(CityhotelsAdapter );

        //nearby attractions recyclerview
        populateNearbyLists();
        CitynearbydestAdapter = new NearbyDestinationsAdapter(Nearby_image,Nearby_title,Nearby_distance,getApplicationContext());
        LinearLayoutManager NearbyLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rv_NearbyDest.setLayoutManager(NearbyLayoutManager);
        rv_NearbyDest.setAdapter(CitynearbydestAdapter );
    }

    private void populateNearbyLists() {

        Nearby_image.add(R.drawable.nd1);
        Nearby_image.add(R.drawable.nd2);
        Nearby_image.add(R.drawable.nd3);
        Nearby_image.add(R.drawable.nd4);

        Nearby_title.add("Naples");
        Nearby_title.add("Apulia");
        Nearby_title.add("Florence");
        Nearby_title.add("Pisa");

        Nearby_distance.add("188");
        Nearby_distance.add("179");
        Nearby_distance.add("230");
        Nearby_distance.add("264");
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

    private void populateHotelsLists() {

        hotel_total_reviews_lists.add("322 reviews") ;
        hotel_total_reviews_lists.add("59 reviews") ;
        hotel_total_reviews_lists.add("165 reviews") ;
        hotel_total_reviews_lists.add("132 reviews") ;

        hotel_ratings_lists.add("5") ;
        hotel_ratings_lists.add("4.3") ;
        hotel_ratings_lists.add("4.8") ;
        hotel_ratings_lists.add("4.7") ;

        hotel_name_lists.add("UNAHOTELS Decò Roma") ;
        hotel_name_lists.add("Palazzo De Cupis") ;
        hotel_name_lists.add("VOI Donna Camilla Savelli Hotel") ;
        hotel_name_lists.add("Sofitel Rome Villa Borghese") ;

        hotel_cost_lists.add("$156") ;
        hotel_cost_lists.add("$349") ;
        hotel_cost_lists.add("$190") ;
        hotel_cost_lists.add("$190") ;

        hotel_distance_lists.add("491m");
        hotel_distance_lists.add("320m");
        hotel_distance_lists.add("747m");
        hotel_distance_lists.add("747m");

        hotel_image_lists.add(R.drawable.ch1);
        hotel_image_lists.add(R.drawable.ch2);
        hotel_image_lists.add(R.drawable.ch3);
        hotel_image_lists.add(R.drawable.ch4);

    }

    private void populateCityAttractionsList() {

        Att_Aimage.add(R.drawable.att1);
        Att_Aimage.add(R.drawable.att2);
        Att_Aimage.add(R.drawable.att3);
        Att_Aimage.add(R.drawable.att4);

        Att_Atitle.add("Colosseum") ;
        Att_Atitle.add("The Pantheon") ;
        Att_Atitle.add("Castel Sant'Angelo") ;
        Att_Atitle.add("Arch of Constantine") ;

        Att_Atiming.add("8:30AM - 7:15PM");
        Att_Atiming.add("9:00AM - 6:00PM");
        Att_Atiming.add("9:00AM - 7:30PM");
        Att_Atiming.add("8:30AM - 7:00PM");

        Att_Adistance.add("25");
        Att_Adistance.add("11");
        Att_Adistance.add("15");
        Att_Adistance.add("8");

        Att_Arating.add("4.8");
        Att_Arating.add("4.5");
        Att_Arating.add("5");
        Att_Arating.add("4.9");

        Att_Asite.add("Historical Site");
        Att_Asite.add("Historical Site");
        Att_Asite.add("Castle");
        Att_Asite.add("Historical Site");


    }

    private void populatedetailssliderimages() {
        images.add(R.drawable.c1);
        images.add(R.drawable.c2);
        images.add(R.drawable.c3);
        images.add(R.drawable.c4);
    }
}