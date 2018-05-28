package com.vijayjaidewan01vivekrai.onboardlistener_github;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by MR VIVEK RAI on 28-05-2018.
 */

public class Adapter extends PagerAdapter {

    private Context context;
    private LayoutInflater inflater;



    public Adapter(Context context) {
        this.context = context;
    }

    public int[] images = {
        R.drawable.android,
        R.drawable.android_b,
        R.drawable.bicycle_icon,
    };

    public String[] name = {
            "Aestro",
            "Blender",
            "Cupcake"
    };


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_layout, container, false);

        TextView textView = view.findViewById(R.id.text_view);
        ImageView imageView = view.findViewById(R.id.image_view);

        textView.setText(name[position]);
        imageView.setImageResource(images[position]);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
