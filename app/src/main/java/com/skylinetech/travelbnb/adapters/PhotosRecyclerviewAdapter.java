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

public class PhotosRecyclerviewAdapter extends RecyclerView.Adapter<PhotosRecyclerviewAdapter.RecyclerItemViewHolder> {


    private List<Integer> ImagesList;
    Context context;


    public PhotosRecyclerviewAdapter( List<Integer> ImagesList, Context context){

        this.ImagesList = ImagesList;
        this.context = context;
    }

    @Override
    public PhotosRecyclerviewAdapter.RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View recyleritemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_layout, parent, false);
        PhotosRecyclerviewAdapter.RecyclerItemViewHolder gvh = new PhotosRecyclerviewAdapter.RecyclerItemViewHolder(recyleritemView);



        return gvh;
    }

    @Override
    public void onBindViewHolder(final PhotosRecyclerviewAdapter.RecyclerItemViewHolder holder, final int position) {

        holder.imageView.setImageResource(ImagesList.get(position));

    }

    @Override
    public int getItemCount() {
        return ImagesList.size();
    }

    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public RecyclerItemViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.photos_img);
        }
    }
}