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

public class NotificationRecyclerAdapter extends RecyclerView.Adapter<NotificationRecyclerAdapter.RecyclerItemViewHolder> {

    private List<String> NamesList;
    private List<Integer> ImagesList;
    private List<String> TimeList;
    Context context;


    public NotificationRecyclerAdapter(List<String> NamesList, List<Integer> ImagesList, List<String> TimeList, Context context){
        this.NamesList = NamesList;
        this.ImagesList = ImagesList;
        this.TimeList = TimeList;
        this.context = context;
    }

    @Override
    public NotificationRecyclerAdapter.RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View recyleritemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.notifications_layout, parent, false);
        NotificationRecyclerAdapter.RecyclerItemViewHolder gvh = new NotificationRecyclerAdapter.RecyclerItemViewHolder(recyleritemView);



        return gvh;
    }

    @Override
    public void onBindViewHolder(final NotificationRecyclerAdapter.RecyclerItemViewHolder holder, final int position) {

        holder.imageView.setImageResource(ImagesList.get(position));
        holder.name.setText(NamesList.get(position));
        holder.time.setText(TimeList.get(position));

    }

    @Override
    public int getItemCount() {
        return NamesList.size();
    }

    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,time;
        public RecyclerItemViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.notifi_user_image);
            name=view.findViewById(R.id.txt_Notifi_text);
            time = view.findViewById(R.id.txt_Notifi_time);
        }
    }
}