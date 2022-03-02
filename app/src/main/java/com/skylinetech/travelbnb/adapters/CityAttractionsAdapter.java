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

public class CityAttractionsAdapter extends RecyclerView.Adapter<CityAttractionsAdapter.RecyclerItemViewHolder> {

    private List<RecyclerClass> attractions_List;
    Context context;
    List<Integer> Att_image = new ArrayList<>();
    List<String> Att_title = new ArrayList<>();
    List<String> Att_timing = new ArrayList<>();
    List<String> Att_distance = new ArrayList<>();
    List<String> Att_rating = new ArrayList<>();
    List<String> Att_site = new ArrayList<>();

    public CityAttractionsAdapter(List<Integer> Att_image, List<String> Att_title,List<String> Att_timing,List<String> Att_distance,List<String> Att_rating,List<String> Att_site, Context context){
        this.Att_image = Att_image;
        this.Att_title = Att_title;
        this.Att_timing = Att_timing;
        this.Att_distance = Att_distance;
        this.Att_rating = Att_rating;
        this.Att_site = Att_site;
        this.context = context;
    }

    @Override
    public CityAttractionsAdapter.RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View recyleritemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_attraction_layout, parent, false);
        CityAttractionsAdapter.RecyclerItemViewHolder gvh = new CityAttractionsAdapter.RecyclerItemViewHolder(recyleritemView);



        return gvh;
    }

    @Override
    public void onBindViewHolder(final CityAttractionsAdapter.RecyclerItemViewHolder holder, final int position) {

        holder.imageView.setImageResource(Att_image.get(position));
        holder.title.setText(Att_title.get(position));
        holder.timing.setText(Att_timing.get(position));
        holder.distance.setText(Att_distance.get(position));
        holder.rating.setText(Att_rating.get(position));
        holder.site.setText(Att_site.get(position));

    }

    @Override
    public int getItemCount() {
        return Att_title.size();
    }

    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title,timing,distance,rating,site;
        public RecyclerItemViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.city_att_lyt_image);
            title=view.findViewById(R.id.city_att_lyt_title);
            timing = view.findViewById(R.id.city_att_lyt_timing);
            distance = view.findViewById(R.id.city_att_lyt_distance);
            rating = view.findViewById(R.id.city_att_lyt_rating);
            site = view.findViewById(R.id.city_att_lyt_site);
        }
    }
}