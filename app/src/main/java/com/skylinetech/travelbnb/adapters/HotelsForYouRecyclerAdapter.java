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

public class HotelsForYouRecyclerAdapter extends RecyclerView.Adapter<HotelsForYouRecyclerAdapter.RecyclerItemViewHolder> {

    private List<RecyclerClass> PlacesList;
    Context context;
    List<String> Price = new ArrayList<>();

    public HotelsForYouRecyclerAdapter(List<RecyclerClass> PlacesList,List<String> Price, Context context){
        this.PlacesList = PlacesList;
        this.Price = Price;
        this.context = context;
    }

    @Override
    public RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View recyleritemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotels_layout, parent, false);
        RecyclerItemViewHolder gvh = new RecyclerItemViewHolder(recyleritemView);



        return gvh;
    }

    @Override
    public void onBindViewHolder(final RecyclerItemViewHolder holder, final int position) {

        holder.imageView.setImageResource(PlacesList.get(position).getPlaceImage());
        holder.txtview.setText(PlacesList.get(position).getPlaceName());
        holder.country.setText(PlacesList.get(position).getPlaceCountry());
        holder.price.setText(Price.get(position));



    }

    @Override
    public int getItemCount() {
        return PlacesList.size();
    }

    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtview,country,price;
        public RecyclerItemViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.imgR);
            txtview=view.findViewById(R.id.txttitle);
            country = view.findViewById(R.id.places_country);
            price = view.findViewById(R.id.txtprice);

        }
    }
}