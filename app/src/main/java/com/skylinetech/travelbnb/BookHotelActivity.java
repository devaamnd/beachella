package com.skylinetech.travelbnb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.skylinetech.travelbnb.adapters.DetailsViewpagerAdapter;
import com.skylinetech.travelbnb.adapters.HotelRoomsAdapter;
import com.skylinetech.travelbnb.adapters.HotelSearchResultAdapter;

import java.util.ArrayList;
import java.util.List;

public class BookHotelActivity extends AppCompatActivity {

    RecyclerView rvHotelRoom;
    HotelRoomsAdapter hotelRoomsAdapter;
    ViewPager hotelimageslider;
    DetailsViewpagerAdapter hotelImageViewpagerAdapter;
    List<Integer> images = new ArrayList<Integer>();

    List<Integer> Room_image = new ArrayList<>();
    List<String> Room_name = new ArrayList<>();
    List<String> Room_people = new ArrayList<>();
    List<String> Room_beds = new ArrayList<>();
    List<String> Room_price = new ArrayList<>();
    List<String> Room_totalprice = new ArrayList<>();
    List<String> Room_roomsleft = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_hotel);

        rvHotelRoom = findViewById(R.id.rv_hotel_rooms);

        populateHotelRoomsList();
        hotelRoomsAdapter = new HotelRoomsAdapter(Room_image,Room_name,Room_people,Room_beds,Room_price,Room_totalprice,Room_roomsleft, getApplicationContext());
        LinearLayoutManager attractionLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvHotelRoom.setLayoutManager(attractionLayoutManager);
        rvHotelRoom.setAdapter(hotelRoomsAdapter );


        hotelimageslider = findViewById(R.id.vp_hotel_details_images);
                //Image Slider
        populatehotelsliderimages();
        hotelImageViewpagerAdapter = new DetailsViewpagerAdapter(getApplicationContext(),images);
        hotelimageslider.setAdapter(hotelImageViewpagerAdapter);
    }

    private void populatehotelsliderimages() {
        images.add(R.drawable.h11);
        images.add(R.drawable.h12);
        images.add(R.drawable.h13);
        images.add(R.drawable.h14);
    }

    private void populateHotelRoomsList() {

        Room_image.add(R.drawable.room1);
        Room_image.add(R.drawable.room2);
        Room_image.add(R.drawable.room3);
        Room_image.add(R.drawable.room4);

        Room_name.add("Classic Room");
        Room_name.add("Comfort Room");
        Room_name.add("Business Single Room");
        Room_name.add("Deluxe Room");

        Room_people.add("2");
        Room_people.add("1");
        Room_people.add("1");
        Room_people.add("2");

        Room_beds.add("2");
        Room_beds.add("2");
        Room_beds.add("1");
        Room_beds.add("2");

        Room_price.add("$115");
        Room_price.add("$133");
        Room_price.add("$140");
        Room_price.add("$209");

        Room_totalprice.add("$126");
        Room_totalprice.add("$147");
        Room_totalprice.add("$155");
        Room_totalprice.add("$229");

        Room_roomsleft.add("6");
        Room_roomsleft.add("2");
        Room_roomsleft.add("4");
        Room_roomsleft.add("1");

    }
}