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

public class StoriesMainAdapter extends RecyclerView.Adapter<StoriesMainAdapter.RecyclerItemViewHolder> {



    private List<Integer> UserImage;
    private List<String> UserName;
    Context context;

    public StoriesMainAdapter( List<Integer> UserImage, List<String> UserName,  Context context) {

        this.UserImage = UserImage;
        this.UserName = UserName;
        this.context = context;
    }

    @Override
    public StoriesMainAdapter.RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View recyleritemView;
        recyleritemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.stories_main_layout, parent, false);
        StoriesMainAdapter.RecyclerItemViewHolder gvh = new StoriesMainAdapter.RecyclerItemViewHolder(recyleritemView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(final StoriesMainAdapter.RecyclerItemViewHolder holder, final int position) {

        holder.UserImage.setImageResource(UserImage.get(position));
        holder.Username.setText(UserName.get(position));


    }

    @Override
    public int getItemCount() {
        return UserImage.size();
    }

    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        ImageView UserImage;
        TextView Username;
        public RecyclerItemViewHolder(View view) {
            super(view);
            UserImage = view.findViewById(R.id.stories_main_user_image);
            Username = view.findViewById(R.id.stories_main_user_name);

        }
    }
}