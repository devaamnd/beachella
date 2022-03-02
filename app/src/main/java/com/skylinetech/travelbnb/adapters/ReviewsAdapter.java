package com.skylinetech.travelbnb.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.skylinetech.travelbnb.R;

import java.util.ArrayList;
import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.RecyclerItemViewHolder> {

    List<String> reviews_List = new ArrayList<>();
    List<String> names_List;
    List<String> rating_List;
    List<Integer> images_List;
    Context context;

public ReviewsAdapter(List<String> reviews_List,List<String> names_List,List<String> rating_List,List<Integer> images_List, Context context){
        this.reviews_List = reviews_List;
        this.names_List = names_List;
        this.rating_List = rating_List;
        this.images_List = images_List;
        this.context = context;
        }

@Override
public ReviewsAdapter.RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View recyleritemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.reviews_layout, parent, false);
        ReviewsAdapter.RecyclerItemViewHolder gvh = new ReviewsAdapter.RecyclerItemViewHolder(recyleritemView);
        return gvh;
        }

@Override
public void onBindViewHolder(ReviewsAdapter.RecyclerItemViewHolder holder, final int position) {
        holder.txt_review.setText(reviews_List.get(position));
        holder.txt_names.setText(names_List.get(position));
        holder.Rb.setRating(Float.valueOf(rating_List.get(position)));
        holder.review_image.setImageResource(images_List.get(position));

        }

@Override
public int getItemCount()
        {
        if(reviews_List.size() <= 3) {
        return reviews_List.size();
        }else{
        return 3;
        }
        }

public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
    TextView txt_review,txt_names;
    RatingBar Rb;
    ImageView review_image;

    public RecyclerItemViewHolder(View view) {
        super(view);
        txt_review=view.findViewById(R.id.txt_review);
        txt_names=view.findViewById(R.id.reviews_user_name);
        Rb=view.findViewById(R.id.review_rating);
        review_image = view.findViewById(R.id.reviews_user_image);
    }
}
}