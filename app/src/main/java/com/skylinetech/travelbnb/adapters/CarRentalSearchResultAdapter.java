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

public class CarRentalSearchResultAdapter extends RecyclerView.Adapter<CarRentalSearchResultAdapter.RecyclerItemViewHolder> {

    private List<RecyclerClass> attractions_List;
    Context context;
    List<Integer> CarRental_carimage = new ArrayList<>();
    List<String> CarRental_type = new ArrayList<>();
    List<String> CarRental_name = new ArrayList<>();
    List<Integer> CarRental_companyimage = new ArrayList<>();
    List<String> CarRental_capacity = new ArrayList<>();
    List<String> CarRental_geartype = new ArrayList<>();
    List<String> CarRental_price = new ArrayList<>();

    public CarRentalSearchResultAdapter(List<Integer> CarRental_carimage, List<String> CarRental_type, List<String> CarRental_name, List<Integer> CarRental_companyimage, List<String> CarRental_capacity, List<String> CarRental_geartype, List<String> CarRental_price,  Context context){
        this.CarRental_carimage = CarRental_carimage;
        this.CarRental_type = CarRental_type;
        this.CarRental_name = CarRental_name;
        this.CarRental_companyimage = CarRental_companyimage;
        this.CarRental_capacity = CarRental_capacity;
        this.CarRental_geartype = CarRental_geartype;
        this.CarRental_price = CarRental_price;
        this.context = context;
    }

    @Override
    public CarRentalSearchResultAdapter.RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View recyleritemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cars_layout, parent, false);
        CarRentalSearchResultAdapter.RecyclerItemViewHolder gvh = new CarRentalSearchResultAdapter.RecyclerItemViewHolder(recyleritemView);



        return gvh;
    }

    @Override
    public void onBindViewHolder(final CarRentalSearchResultAdapter.RecyclerItemViewHolder holder, final int position) {


        holder.carimage.setImageResource(CarRental_carimage.get(position));
        holder.type.setText(CarRental_type.get(position));
        holder.name.setText(CarRental_name.get(position));
        holder.companyimage.setImageResource(CarRental_companyimage.get(position));
        holder.capacity.setText(CarRental_capacity.get(position));
        holder.geartype.setText(CarRental_geartype.get(position));
        holder.price.setText(CarRental_price.get(position));
        holder.btnCarBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(context, CheckoutActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return CarRental_name.size();
    }

    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        ImageView carimage,companyimage;
        TextView name,type,capacity,geartype,price;
        Button btnCarBook;
        public RecyclerItemViewHolder(View view) {
            super(view);
            carimage=view.findViewById(R.id.lyt_car_rental_carimage);
            name=view.findViewById(R.id.lyt_car_rental_name);
            companyimage = view.findViewById(R.id.lyt_car_rental_companyimage);
            type = view.findViewById(R.id.lyt_car_rental_type);
            capacity = view.findViewById(R.id.lyt_car_rental_capacity);
            geartype = view.findViewById(R.id.lyt_car_rental_geartype);
            price = view.findViewById(R.id.lyt_car_rental_price);
            btnCarBook = view.findViewById(R.id.btn_Car_Book);
        }
    }
}