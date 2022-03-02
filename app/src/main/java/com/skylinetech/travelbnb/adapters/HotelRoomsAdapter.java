package com.skylinetech.travelbnb.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.skylinetech.travelbnb.CheckoutActivity;
import com.skylinetech.travelbnb.R;
import com.skylinetech.travelbnb.classes.RecyclerClass;

import java.util.ArrayList;
import java.util.List;

public class HotelRoomsAdapter extends RecyclerView.Adapter<HotelRoomsAdapter.RecyclerItemViewHolder> {

    private List<RecyclerClass> attractions_List;
    Context context;
    List<Integer> Room_image = new ArrayList<>();
    List<String> Room_name = new ArrayList<>();
    List<String> Room_people = new ArrayList<>();
    List<String> Room_beds = new ArrayList<>();
    List<String> Room_price = new ArrayList<>();
    List<String> Room_totalprice = new ArrayList<>();
    List<String> Room_roomsleft = new ArrayList<>();

    public HotelRoomsAdapter(List<Integer> Room_image, List<String> Room_name, List<String> Room_people, List<String> Room_beds, List<String> Room_price, List<String> Room_totalprice, List<String> Room_roomsleft, Context context){
        this.Room_image = Room_image;
        this.Room_name = Room_name;
        this.Room_people = Room_people;
        this.Room_beds = Room_beds;
        this.Room_price = Room_price;
        this.Room_totalprice = Room_totalprice;
        this.Room_roomsleft = Room_roomsleft;
        this.context = context;
    }

    @Override
    public HotelRoomsAdapter.RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View recyleritemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_room_lyt, parent, false);
        HotelRoomsAdapter.RecyclerItemViewHolder gvh = new HotelRoomsAdapter.RecyclerItemViewHolder(recyleritemView);



        return gvh;
    }

    @Override
    public void onBindViewHolder(final HotelRoomsAdapter.RecyclerItemViewHolder holder, final int position) {


        holder.imageView.setImageResource(Room_image.get(position));
        holder.name.setText(Room_name.get(position));
        holder.people.setText(Room_people.get(position));
        holder.beds.setText(Room_beds.get(position));
        holder.price.setText(Room_price.get(position));
        holder.totalprice.setText(Room_totalprice.get(position));
        holder.roomsleft.setText(Room_roomsleft.get(position));

        holder.btnBookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(context, CheckoutActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return Room_name.size();
    }

    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,people,beds,price,totalprice,roomsleft;
        Button btnBookNow;

        public RecyclerItemViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.lyt_room_image);
            name=view.findViewById(R.id.lyt_room_name);
            people = view.findViewById(R.id.lyt_room_people);
            beds = view.findViewById(R.id.lyt_room_bed);
            price = view.findViewById(R.id.lyt_room_price);
            totalprice = view.findViewById(R.id.lyt_room_total_price);
            roomsleft = view.findViewById(R.id.lyt_room_room_left);
            btnBookNow = view.findViewById(R.id.lyt_room_book_btn);

        }
    }
}