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

public class AttractionsAdapter extends RecyclerView.Adapter<AttractionsAdapter.RecyclerItemViewHolder> {

    private List<RecyclerClass> attractions_List;
    Context context;
    List<String> Rp = new ArrayList<>();

    public AttractionsAdapter(List<RecyclerClass> attractions_List, Context context){
        this.attractions_List = attractions_List;
        this.context = context;
    }

    @Override
    public AttractionsAdapter.RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View recyleritemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.attractions_layout, parent, false);
        AttractionsAdapter.RecyclerItemViewHolder gvh = new AttractionsAdapter.RecyclerItemViewHolder(recyleritemView);



        return gvh;
    }

    @Override
    public void onBindViewHolder(final AttractionsAdapter.RecyclerItemViewHolder holder, final int position) {

        holder.imageView.setImageResource(attractions_List.get(position).getPlaceImage());
        holder.txtview.setText(attractions_List.get(position).getPlaceName());
        holder.country.setText(attractions_List.get(position).getPlaceCountry());



    }

    @Override
    public int getItemCount() {
        return attractions_List.size();
    }

    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtview,country;
        public RecyclerItemViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.attractions_image);
            txtview=view.findViewById(R.id.attractions_title);
            country = view.findViewById(R.id.attractions_country);

        }
    }
}