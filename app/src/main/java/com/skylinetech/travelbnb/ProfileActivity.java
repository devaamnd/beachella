package com.skylinetech.travelbnb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.skylinetech.travelbnb.adapters.PhotosRecyclerviewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    List<Integer> tour_image_lists = new ArrayList<>();
    RecyclerView rvPhotos;
    PhotosRecyclerviewAdapter PhotosRecyclerAdapter;
    ImageButton btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnSettings = findViewById(R.id.btn_profile_settings);
        rvPhotos = findViewById(R.id.rv_user_photos);
        populatePhotosLists();
        PhotosRecyclerAdapter = new PhotosRecyclerviewAdapter(tour_image_lists, getApplicationContext());
        rvPhotos.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        rvPhotos.setAdapter(PhotosRecyclerAdapter);

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
            }
        });
    }

    private void populatePhotosLists() {

        tour_image_lists.add(R.drawable.ph1);
        tour_image_lists.add(R.drawable.ph2);
        tour_image_lists.add(R.drawable.ph3);
        tour_image_lists.add(R.drawable.ph4);
        tour_image_lists.add(R.drawable.ph5);
        tour_image_lists.add(R.drawable.ph6);
        tour_image_lists.add(R.drawable.ph7);
        tour_image_lists.add(R.drawable.ph8);


    }
}