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

public class NearbyDestinationsAdapter extends RecyclerView.Adapter<NearbyDestinationsAdapter.RecyclerItemViewHolder> {


    Context context;
    List<Integer> Att_image = new ArrayList<>();
    List<String> Att_title = new ArrayList<>();
    List<String> Att_distance = new ArrayList<>();

    public NearbyDestinationsAdapter(List<Integer> Att_image, List<String> Att_title, List<String> Att_distance, Context context){
        this.Att_image = Att_image;
        this.Att_title = Att_title;
        this.Att_distance = Att_distance;
        this.context = context;
    }

    @Override
    public NearbyDestinationsAdapter.RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View recyleritemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nearby_destinations_layout, parent, false);
        NearbyDestinationsAdapter.RecyclerItemViewHolder gvh = new NearbyDestinationsAdapter.RecyclerItemViewHolder(recyleritemView);



        return gvh;
    }

    @Override
    public void onBindViewHolder(final NearbyDestinationsAdapter.RecyclerItemViewHolder holder, final int position) {

        holder.imageView.setImageResource(Att_image.get(position));
        holder.title.setText(Att_title.get(position));
        holder.distance.setText(Att_distance.get(position));

    }

    @Override
    public int getItemCount() {
        return Att_title.size();
    }

    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title,distance;
        public RecyclerItemViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.nearby_dest_image);
            title=view.findViewById(R.id.nearby_dest_title);
            distance = view.findViewById(R.id.nearby_dest_distance);
        }
    }
}