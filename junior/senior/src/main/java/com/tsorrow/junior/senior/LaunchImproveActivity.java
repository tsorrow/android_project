package com.tsorrow.junior.senior;

import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;

import com.tsorrow.junior.senior.adapter.LaunchImproveAdapter;
import com.tsorrow.junior.senior.adapter.MobilePagerAdapter;
import com.tsorrow.junior.senior.bean.GoodsInfo;

import java.util.ArrayList;

public class LaunchImproveActivity extends AppCompatActivity {
    private int[] lanuchImageArray = {R.drawable.guide_bg1, R.drawable.guide_bg2, R.drawable.guide_bg3, R.drawable.guide_bg4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_improve);
        ViewPager vp_launch = (ViewPager) findViewById(R.id.vp_launch);
        LaunchImproveAdapter mAdapter = new LaunchImproveAdapter(getSupportFragmentManager(), lanuchImageArray);
        vp_launch.setAdapter(mAdapter);
        vp_launch.setCurrentItem(0);
    }
}
