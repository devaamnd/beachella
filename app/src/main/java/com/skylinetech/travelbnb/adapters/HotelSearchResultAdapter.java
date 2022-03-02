package com.skylinetech.travelbnb.adapters;

import android.content.Context;
import android.graphics.Paint;
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

public class HotelSearchResultAdapter extends RecyclerView.Adapter<HotelSearchResultAdapter.RecyclerItemViewHolder> {

    private List<RecyclerClass> attractions_List;
    Context context;
    List<Integer> HotelRes_image = new ArrayList<>();
    List<String> HotelRes_name = new ArrayList<>();
    List<Integer> HotelRes_starimage = new ArrayList<>();
    List<String> HotelRes_rating = new ArrayList<>();
    List<String> HotelRes_ratingstatus = new ArrayList<>();
    List<String> HotelRes_distance = new ArrayList<>();
    List<String> HotelRes_discprecent = new ArrayList<>();
    List<String> HotelRes_originalprice = new ArrayList<>();
    List<String> HotelRes_discountprice = new ArrayList<>();

    public HotelSearchResultAdapter(List<Integer> HotelRes_image, List<String> HotelRes_name,List<Integer> HotelRes_starimage, List<String> HotelRes_rating, List<String> HotelRes_ratingstatus, List<String> HotelRes_distance, List<String> HotelRes_discprecent, List<String>HotelRes_originalprice, List<String> HotelRes_discountprice, Context context){
        this.HotelRes_image = HotelRes_image;
        this.HotelRes_name = HotelRes_name;
        this.HotelRes_starimage = HotelRes_starimage;
        this.HotelRes_rating = HotelRes_rating;
        this.HotelRes_ratingstatus = HotelRes_ratingstatus;
        this.HotelRes_distance = HotelRes_distance;
        this.HotelRes_discprecent = HotelRes_discprecent;
        this.HotelRes_originalprice = HotelRes_originalprice;
        this.HotelRes_discountprice = HotelRes_discountprice;
        this.context = context;
    }

    @Override
    public HotelSearchResultAdapter.RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View recyleritemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotelresultlayout, parent, false);
        HotelSearchResultAdapter.RecyclerItemViewHolder gvh = new HotelSearchResultAdapter.RecyclerItemViewHolder(recyleritemView);



        return gvh;
    }

    @Override
    public void onBindViewHolder(final HotelSearchResultAdapter.RecyclerItemViewHolder holder, final int position) {

        holder.imageView.setImageResource(HotelRes_image.get(position));
        holder.name.setText(HotelRes_name.get(position));
        holder.startimage.setImageResource(HotelRes_starimage.get(position));
        holder.rating.setText(HotelRes_rating.get(position));
        holder.ratingstatus.setText(HotelRes_ratingstatus.get(position));
        holder.distance.setText(HotelRes_distance.get(position));
        holder.discpercent.setText(HotelRes_discprecent.get(position));
        holder.orgprice.setPaintFlags(holder.orgprice.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        holder.discprice.setText(HotelRes_discountprice.get(position));
        holder.orgprice.setText(HotelRes_originalprice.get(position));

    }

    @Override
    public int getItemCount() {
        return HotelRes_name.size();
    }

    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView,startimage;
        TextView name,rating,ratingstatus,distance,discpercent,orgprice,discprice;
        public RecyclerItemViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.lyt_hotel_search_r_image);
            name=view.findViewById(R.id.lyt_hotel_search_r_name);
            startimage = view.findViewById(R.id.lyt_hotel_search_r_starsimage);
            rating = view.findViewById(R.id.lyt_hotel_search_r_rating);
            ratingstatus = view.findViewById(R.id.lyt_hotel_search_r_ratingstatus);
            distance = view.findViewById(R.id.lyt_hotel_search_r_distance);
            discpercent = view.findViewById(R.id.lyt_hotel_search_r_discpercent);
            discprice = view.findViewById(R.id.lyt_hotel_search_r_discountprice);
            orgprice = view.findViewById(R.id.lyt_hotel_search_r_originalprice);
        }
    }
}