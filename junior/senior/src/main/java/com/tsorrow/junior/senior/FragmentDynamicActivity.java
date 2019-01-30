package com.tsorrow.junior.senior;

import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;

import com.tsorrow.junior.senior.adapter.MobilePagerAdapter;
import com.tsorrow.junior.senior.bean.GoodsInfo;

import java.util.ArrayList;

public class FragmentDynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dynamic);
        PagerTabStrip pts_tab = (PagerTabStrip) findViewById(R.id.pts_tab);
        pts_tab.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        ViewPager vp_content = (ViewPager) findViewById(R.id.vp_content);
        ArrayList<GoodsInfo> goodsList = GoodsInfo.getDefaultList();
        MobilePagerAdapter mAdapter = new MobilePagerAdapter(getSupportFragmentManager(), goodsList);
        vp_content.setAdapter(mAdapter);
        vp_content.setCurrentItem(0);
    }
}
