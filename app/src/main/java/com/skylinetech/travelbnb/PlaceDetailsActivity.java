package com.skylinetech.travelbnb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.skylinetech.travelbnb.adapters.DetailsViewpagerAdapter;
import com.skylinetech.travelbnb.adapters.HotelsAdapter;
import com.skylinetech.travelbnb.adapters.ReviewsAdapter;
import com.skylinetech.travelbnb.adapters.ToursRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PlaceDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

    ViewPager vpDetailsImages;
    DetailsViewpagerAdapter detailsViewpagerAdapter;
    List<Integer> images = new ArrayList<Integer>();
    RecyclerView rv_user_reviews, rv_tours,rv_hotels;
    ReviewsAdapter reviewsAdapter;
    ToursRecyclerAdapter toursRecyclerAdapter;
    HotelsAdapter hotelsAdapter;
    Button btnMoreReviews;
    SupportMapFragment mapFragment;

    List<String> reviews_lists = new ArrayList<>();
    List<String> rating_lists = new ArrayList<>();
    List<String> names_lists = new ArrayList<>();
    List<Integer> images_lists = new ArrayList<>();

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
        setContentView(R.layout.activity_place_details);

        //initialize
        vpDetailsImages = findViewById(R.id.vp_details_images);
        rv_user_reviews = findViewById(R.id.details_places_rv_reviews);
        btnMoreReviews = findViewById(R.id.details_places_more_reviews);
        rv_tours = findViewById(R.id.details_places_rv_tours);
        rv_hotels = findViewById(R.id.details_places_rv_hotels);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.details_places_location);

        Makestatusbartransparent();

        //More Reviews Button
        btnMoreReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlaceDetailsActivity.this,AllReviewsActivity.class);
                startActivity(intent);
            }
        });

        //Image Slider
        populatedetailsimages();
        detailsViewpagerAdapter = new DetailsViewpagerAdapter(getApplicationContext(),images);
        vpDetailsImages.setAdapter(detailsViewpagerAdapter);

        //Reviews Recyclerview
        populateLists();
        reviewsAdapter = new ReviewsAdapter(reviews_lists,names_lists,rating_lists,images_lists, getApplicationContext());
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv_user_reviews.setLayoutManager(verticalLayoutManager);
        rv_user_reviews.setAdapter(reviewsAdapter );

        //Tours Recyclerview
        populateToursLists();
        toursRecyclerAdapter = new ToursRecyclerAdapter(tour_name_lists,tour_image_lists,tour_ratings_lists,total_reviews_lists, tour_cost_lists, getApplicationContext());
        LinearLayoutManager toursLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        rv_tours.setLayoutManager(toursLayoutManager);
        rv_tours.setAdapter(toursRecyclerAdapter );

        //Hotels Recyclerview
        populateHotelsLists();
        hotelsAdapter = new HotelsAdapter(hotel_name_lists,hotel_image_lists,hotel_ratings_lists,hotel_total_reviews_lists, hotel_cost_lists,hotel_distance_lists, getApplicationContext());
        LinearLayoutManager hotelsLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv_hotels.setLayoutManager(hotelsLayoutManager);
        rv_hotels.setAdapter(hotelsAdapter );

        //Mapview
        mapFragment.getMapAsync(this);


    }

    private void Makestatusbartransparent() {

        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {

        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    private void populateHotelsLists() {

        hotel_total_reviews_lists.add("322 reviews") ;
        hotel_total_reviews_lists.add("59 reviews") ;
        hotel_total_reviews_lists.add("165 reviews") ;

        hotel_ratings_lists.add("5") ;
        hotel_ratings_lists.add("4.3") ;
        hotel_ratings_lists.add("4.8") ;

        hotel_name_lists.add("Mercure Roma Centro Colosseo") ;
        hotel_name_lists.add("FH55 Grand Hotel Palatino") ;
        hotel_name_lists.add("Hotel Palazzo Manfredi – Relais & Chateaux") ;

        hotel_cost_lists.add("$299") ;
        hotel_cost_lists.add("$349") ;
        hotel_cost_lists.add("$190") ;

        hotel_distance_lists.add("491m");
        hotel_distance_lists.add("320m");
        hotel_distance_lists.add("747m");

        hotel_image_lists.add(R.drawable.h1);
        hotel_image_lists.add(R.drawable.h2);
        hotel_image_lists.add(R.drawable.h3);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng sydney = new LatLng(41.890251, 12.492373);
        googleMap.addMarker(new MarkerOptions()
                .position(sydney)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.locationmarker))
                .title("Colosseum"));
        googleMap.getFocusedBuilding();
        googleMap.setMapType(1);
        LatLngBounds boundary = new LatLngBounds(
                new LatLng(41.890251, 12.492373), // SW bounds
                new LatLng(41.890251, 12.492373)  // NE bounds
        );

        // Constrain the camera target to the Adelaide bounds.
        googleMap.setLatLngBoundsForCameraTarget(boundary);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(sydney) // Center Set
                .zoom(15.0f)                // Zoom
                .bearing(90)                // Orientation of the camera to east
                .tilt(30)                   // Tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }

    private void populateToursLists() {

        tour_name_lists.add("90-Minutes Colosseum Restricted Gladiator's Arena Tour");
        tour_name_lists.add("Colosseum, Palatine Hill and Roman Forum Guided Tour");
        tour_name_lists.add("Rome: Colosseum Highlights Guided Tour");
        tour_name_lists.add("Colosseum Underground and Roman Forum Tour");

        tour_image_lists.add(R.drawable.tour1);
        tour_image_lists.add(R.drawable.tour2);
        tour_image_lists.add(R.drawable.tour3);
        tour_image_lists.add(R.drawable.tour4);

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

    private void populatedetailsimages() {
        images.add(R.drawable.col1);
        images.add(R.drawable.col2);
        images.add(R.drawable.col3);
        images.add(R.drawable.col4);
        images.add(R.drawable.col5);
        images.add(R.drawable.col6);
    }

    private void populateLists() {
        reviews_lists.add("You can by a pass for historical sites and rush the lane on it. Do not forget about sun - take a covers.");
        reviews_lists.add("just one word...i don't see anythink like this, so wonderful. Maybe in another trip i can go inside");
        reviews_lists.add("A very interesting place to visit. Especially if you are interested in the roman history.");

        images_lists.add(R.drawable.rv1);
        images_lists.add(R.drawable.rv3);
        images_lists.add(R.drawable.rv8);

        names_lists.add("Paul Smith");
        names_lists.add("Sam Bills");
        names_lists.add("Alex Benz");

        rating_lists.add("5");
        rating_lists.add("4.5");
        rating_lists.add("3");



    }
}