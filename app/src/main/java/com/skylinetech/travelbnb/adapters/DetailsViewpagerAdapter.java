package com.skylinetech.travelbnb.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.skylinetech.travelbnb.R;

import java.util.ArrayList;
import java.util.List;

public class DetailsViewpagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    List<Integer> images = new ArrayList<Integer>();

    public DetailsViewpagerAdapter(Context context,List<Integer> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.details_images_layout,container, false);
        final ImageView imageView = (ImageView) view.findViewById(R.id.details_image);
        //TextView name = (TextView) view.findViewById(R.id.slidername);



        //name.setText(names.get(position));
        imageView.setImageResource(images.get(position));


        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}