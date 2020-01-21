package com.hndsolution.battery.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.hndsolution.battery.utils.TouchImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ImageAdapter extends PagerAdapter {
    private final Context mContext;
    private final ArrayList<String> mGalImages;

    /**
     * Initializes and adapter that adds particular image into imageView adapter
     *
     * @param context The context referring this class
     * @param images  Array list containing URLs of images
     */
    public ImageAdapter(Context context, ArrayList<String> images) {
        mGalImages = images;
        this.mContext = context;
    }

    /**
     * Returns count of number of images in array list
     *
     * @return number of images
     */
    @Override
    public int getCount() {
        if (mGalImages == null)
            return 0;
        return mGalImages.size();
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    /***
     * Display image at position in images Array in imageView
     *
     * @param container container view
     * @param position  position of item
     * @return object instantiated
     */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        TouchImageView imageView = new TouchImageView(mContext);

        Picasso.with(mContext).load(mGalImages.get(position)).into(imageView);

        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }
}
