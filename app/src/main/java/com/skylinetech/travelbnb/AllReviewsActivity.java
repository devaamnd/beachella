package com.skylinetech.travelbnb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.skylinetech.travelbnb.adapters.AllReviewListAdapter;

import java.util.ArrayList;
import java.util.List;

public class AllReviewsActivity extends AppCompatActivity {

    RecyclerView rv_all_reviews;
    AllReviewListAdapter allReviewListAdapter;
    List<String> reviews_lists = new ArrayList<>();
    List<String> rating_lists = new ArrayList<>();
    List<String> names_lists = new ArrayList<>();
    List<Integer> images_lists = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_reviews);

        rv_all_reviews = findViewById(R.id.allreviews_rv_reviews);
        populateLists();
        allReviewListAdapter = new AllReviewListAdapter(reviews_lists,names_lists,rating_lists,images_lists, getApplicationContext());
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv_all_reviews.setLayoutManager(verticalLayoutManager);
        rv_all_reviews.setAdapter(allReviewListAdapter );
    }

    private void populateLists() {
        reviews_lists.add("You can by a pass for historical sites and rush the lane on it. Do not forget about sun - take a covers.");
        reviews_lists.add("once in Rome we visited the Colosseum. it was an unforgettable experience. We suggest to read a book on the Roman history before visiting the Colosseum. it takes 2 hours ca");
        reviews_lists.add("just one word...i don't see anythink like this, so wonderful. Maybe in another trip i can go inside");
        reviews_lists.add("eah the Colosseum is a must to see in Rome. I recommend you to read books about it before the visit, and after choose the unguided visit of the monument.");
        reviews_lists.add("Once in Rome, the Colosseum is a must. We suggest to read a book on the roman history before you visit the Colosseum. It was a fantastic experience.");
        reviews_lists.add("Wonderful, huge, old, with many stairs, and huge stairs. You can imagine the long and bloody fights there.");
        reviews_lists.add("The Colosseum is the most beautiful museum I have ever seen. You have to wait a long time to get into there");
        reviews_lists.add("A very interesting place to visit. Especially if you are interested in the roman history.");

        images_lists.add(R.drawable.rv1);
        images_lists.add(R.drawable.rv2);
        images_lists.add(R.drawable.rv3);
        images_lists.add(R.drawable.rv4);
        images_lists.add(R.drawable.rv5);
        images_lists.add(R.drawable.rv6);
        images_lists.add(R.drawable.rv7);
        images_lists.add(R.drawable.rv8);

        names_lists.add("Paul Smith");
        names_lists.add("Steve Lesner");
        names_lists.add("Sam Bills");
        names_lists.add("Dean Rock");
        names_lists.add("Alan Donald");
        names_lists.add("Mike Pence");
        names_lists.add("Joe Morgan");
        names_lists.add("Alex Benz");

        rating_lists.add("5");
        rating_lists.add("4");
        rating_lists.add("4.5");
        rating_lists.add("5");
        rating_lists.add("5");
        rating_lists.add("5");
        rating_lists.add("1");
        rating_lists.add("3");



    }
}