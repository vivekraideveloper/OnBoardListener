package com.vijayjaidewan01vivekrai.onboardlistener_github;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private Adapter adapter;
    private TextView[] dots;
    private Button next;
    private Button previous;
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        linearLayout = findViewById(R.id.linear_layout);

        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);

        adapter = new Adapter(MainActivity.this);
        viewPager.setAdapter(adapter);

        dotsIndidcator(0);
        viewPager.addOnPageChangeListener(listener);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(currentPage + 1);
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(currentPage-1);
            }
        });

    }

    public void dotsIndidcator(int position){
        dots = new TextView[3];
        linearLayout.removeAllViews();

        for (int i = 0 ; i< dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextColor(getResources().getColor(R.color.white));
            dots[i].setTextSize(35);
            linearLayout.addView(dots[i]);
        }

        if (dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }

    ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            dotsIndidcator(position);
            currentPage = position;
            if (position == 0){
                previous.setEnabled(false);
                previous.setVisibility(View.INVISIBLE);
                next.setEnabled(true);
            }else if (position == dots.length -1){
                previous.setEnabled(true);
                previous.setVisibility(View.VISIBLE);
                next.setEnabled(true);
                next.setText("Finish");
                previous.setText("Back");
            }else {
                previous.setEnabled(true);
                previous.setVisibility(View.VISIBLE);
                next.setEnabled(true);
                next.setText("Next");
                previous.setText("Back");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
