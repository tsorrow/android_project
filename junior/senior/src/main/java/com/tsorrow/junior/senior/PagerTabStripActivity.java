package com.tsorrow.junior.senior;

import android.graphics.Color;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Toast;

import com.tsorrow.junior.senior.adapter.ImagePagerAdapater;
import com.tsorrow.junior.senior.bean.GoodsInfo;

import java.util.ArrayList;

public class PagerTabStripActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    private ArrayList<GoodsInfo> goodsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_tab_strip);
        PagerTabStrip pts_tab = (PagerTabStrip) findViewById(R.id.pts_tab);
        pts_tab.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        pts_tab.setTextColor(Color.GREEN);

        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_content);
        goodsList = GoodsInfo.getDefaultList();
        ImagePagerAdapater adapater = new ImagePagerAdapater(this,goodsList);
        viewPager.setAdapter(adapater);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        Toast.makeText(this,"您选中的是"+goodsList.get(i).name,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
