package com.skylinetech.travelbnb.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.skylinetech.travelbnb.R;

import java.util.List;

public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.RecyclerItemViewHolder> {


    private List<Integer> StoryImage;
    private List<Integer> UserImage;
    private List<String> UserName;
    private List<String> Date;
    Context context;


    public StoriesAdapter(List<Integer> StoryImage,List<Integer> UserImage,List<String> UserName,List<String> Date , Context context) {
        this.StoryImage = StoryImage;
        this.UserImage = UserImage;
        this.UserName = UserName;
        this.Date = Date;
        this.context = context;
    }

    @Override
    public StoriesAdapter.RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View recyleritemView;
        recyleritemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.stories_layout, parent, false);
        StoriesAdapter.RecyclerItemViewHolder gvh = new StoriesAdapter.RecyclerItemViewHolder(recyleritemView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(final StoriesAdapter.RecyclerItemViewHolder holder, final int position) {

        holder.StoryImage.setImageResource(StoryImage.get(position));
        holder.UserImage.setImageResource(UserImage.get(position));
        holder.Username.setText(UserName.get(position));
        holder.Date.setText(Date.get(position));
    }

    @Override
    public int getItemCount() {
        return StoryImage.size();
    }

    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        ImageView StoryImage,UserImage;
        TextView Username,Date;
        public RecyclerItemViewHolder(View view) {
            super(view);
            StoryImage = view.findViewById(R.id.stories_image);
            UserImage = view.findViewById(R.id.stories_user_image);
            UserName = view.findViewById(R.id.stories_user_name);
            Date = view.findViewById(R.id.stories_date);

        }
    }
}