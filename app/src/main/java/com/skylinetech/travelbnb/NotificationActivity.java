package com.skylinetech.travelbnb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.skylinetech.travelbnb.adapters.NotificationRecyclerAdapter;
import com.skylinetech.travelbnb.adapters.ToursRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {

    RecyclerView rvNotif;
    NotificationRecyclerAdapter notificationRecyclerAdapter;
    List<String> name_lists = new ArrayList<>();
    List<String> time_lists = new ArrayList<>();
    List<Integer> image_lists = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        rvNotif = findViewById(R.id.rv_notifications);

        populateCityToursLists();
        notificationRecyclerAdapter = new NotificationRecyclerAdapter(name_lists,image_lists,time_lists, getApplicationContext());
        LinearLayoutManager toursLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvNotif.setLayoutManager(toursLayoutManager);
        rvNotif.setAdapter(notificationRecyclerAdapter );

    }

    private void populateCityToursLists() {
        name_lists.add("You have a Flight Booking for Tomorrow");
        name_lists.add("Steve Brooks is now following you ");
        name_lists.add("Now you have a special Promo code to use on your next Car Rental");
        name_lists.add("Jade Allan likes your photo");

        image_lists.add(R.drawable.flight_notif);
        image_lists.add(R.drawable.rv2);
        image_lists.add(R.drawable.maincarrental);
        image_lists.add(R.drawable.rv1);

        time_lists.add("6min ago");
        time_lists.add("3hrs ago");
        time_lists.add("12hrs ago");
        time_lists.add("1day ago");
    }
}