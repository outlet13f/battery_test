package com.hndsolution.battery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.hndsolution.battery.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class BatteryImageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_battery_image);

        Intent intent = getIntent();
        String name = intent.getStringExtra("event_img");
        int pos = intent.getIntExtra("number", -1);

        ArrayList<String> images = intent.getStringArrayListExtra("event_name");

        ViewPager viewPager = findViewById(R.id.view_pager);
        ImageAdapter adapter = new ImageAdapter(this, images);
        viewPager.setAdapter(adapter);
        if (pos != -1)
            viewPager.setCurrentItem(pos);

        setTitle(name);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, BatteryImageActivity.class);
        return intent;
    }
}
