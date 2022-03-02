package com.skylinetech.travelbnb.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.skylinetech.travelbnb.R;
import com.skylinetech.travelbnb.classes.RecyclerClass;

import java.util.ArrayList;
import java.util.List;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.RecyclerItemViewHolder> {

    private List<Integer> DealsList;
    Context context;

    public DealsAdapter(List<Integer> DealsList, Context context) {
        this.DealsList = DealsList;
        this.context = context;
    }

    @Override
    public DealsAdapter.RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View recyleritemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.deals_layout, parent, false);
        DealsAdapter.RecyclerItemViewHolder gvh = new DealsAdapter.RecyclerItemViewHolder(recyleritemView);


        return gvh;
    }

    @Override
    public void onBindViewHolder(final DealsAdapter.RecyclerItemViewHolder holder, final int position) {

        holder.imageView.setImageResource(DealsList.get(position));


    }

    @Override
    public int getItemCount() {
        return DealsList.size();
    }

    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public RecyclerItemViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.deals_image);

        }
    }
}