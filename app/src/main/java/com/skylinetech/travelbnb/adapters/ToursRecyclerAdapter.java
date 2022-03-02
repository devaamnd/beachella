package com.skylinetech.travelbnb.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.skylinetech.travelbnb.R;

import java.util.List;

public class ToursRecyclerAdapter extends RecyclerView.Adapter<ToursRecyclerAdapter.RecyclerItemViewHolder> {

    private List<String> TotalReviewsList;
    private List<String> NamesList;
    private List<String> RatingsList;
    private List<Integer> ImagesList;
    private List<String> CostList;
    Context context;


    public ToursRecyclerAdapter(List<String> NamesList, List<Integer> ImagesList, List<String> RatingsList, List<String> TotalReviewsList, List<String> CostList, Context context){
        this.NamesList = NamesList;
        this.ImagesList = ImagesList;
        this.RatingsList = RatingsList;
        this.TotalReviewsList = TotalReviewsList;
        this.CostList = CostList;
        this.context = context;
    }

    @Override
    public ToursRecyclerAdapter.RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View recyleritemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.placedetails_tour_layout, parent, false);
        ToursRecyclerAdapter.RecyclerItemViewHolder gvh = new ToursRecyclerAdapter.RecyclerItemViewHolder(recyleritemView);



        return gvh;
    }

    @Override
    public void onBindViewHolder(final ToursRecyclerAdapter.RecyclerItemViewHolder holder, final int position) {

        holder.imageView.setImageResource(ImagesList.get(position));
        holder.name.setText(NamesList.get(position));
        holder.rating.setText(RatingsList.get(position));
        holder.totalreviews.setText(TotalReviewsList.get(position));
        holder.cost.setText(CostList.get(position));

    }

    @Override
    public int getItemCount() {
        return NamesList.size();
    }

    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,rating,totalreviews,cost;
        public RecyclerItemViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.tours_image);
            name=view.findViewById(R.id.tours_name);
            rating = view.findViewById(R.id.tours_rating);
            totalreviews = view.findViewById(R.id.tours_total_reviews);
            cost = view.findViewById(R.id.tours_cost);
        }
    }
}