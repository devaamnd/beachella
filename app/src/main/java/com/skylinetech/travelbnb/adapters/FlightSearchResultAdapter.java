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

public class FlightSearchResultAdapter extends RecyclerView.Adapter<FlightSearchResultAdapter.RecyclerItemViewHolder> {

    private List<RecyclerClass> attractions_List;
    Context context;
    List<Integer> FlightRes_image = new ArrayList<>();
    List<String> FlightRes_dep_time = new ArrayList<>();
    List<String> FlightRes_arr_time = new ArrayList<>();
    List<String> FlightRes_price = new ArrayList<>();
    List<String> FlightRes_flight_num = new ArrayList<>();

    public FlightSearchResultAdapter(List<Integer> FlightRes_image, List<String> FlightRes_dep_time, List<String> FlightRes_arr_time, List<String> FlightRes_price, List<String> FlightRes_flight_num, Context context){
        this.FlightRes_image = FlightRes_image;
        this.FlightRes_dep_time = FlightRes_dep_time;
        this.FlightRes_arr_time = FlightRes_arr_time;
        this.FlightRes_price = FlightRes_price;
        this.FlightRes_flight_num = FlightRes_flight_num;
        this.context = context;
    }

    @Override
    public FlightSearchResultAdapter.RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View recyleritemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.flight_search_results_layout, parent, false);
        FlightSearchResultAdapter.RecyclerItemViewHolder gvh = new FlightSearchResultAdapter.RecyclerItemViewHolder(recyleritemView);



        return gvh;
    }

    @Override
    public void onBindViewHolder(final FlightSearchResultAdapter.RecyclerItemViewHolder holder, final int position) {

        holder.imageView.setImageResource(FlightRes_image.get(position));
        holder.deptime.setText(FlightRes_dep_time.get(position));
        holder.arrtime.setText(FlightRes_arr_time.get(position));
        holder.fltprice.setText(FlightRes_price.get(position));
        holder.fltnum.setText(FlightRes_flight_num.get(position));

    }

    @Override
    public int getItemCount() {
        return FlightRes_dep_time.size();
    }

    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView deptime,arrtime,fltprice,fltnum;
        public RecyclerItemViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.FlightRes_Airline_logo);
            deptime=view.findViewById(R.id.FlightRes_departure_time);
            arrtime = view.findViewById(R.id.FlightRes_Arrival_time);
            fltprice = view.findViewById(R.id.FlightRes_price);
            fltnum = view.findViewById(R.id.FlightRes_flight_num);
        }
    }
}