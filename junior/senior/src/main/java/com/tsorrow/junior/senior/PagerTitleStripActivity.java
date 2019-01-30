package com.tsorrow.junior.senior;

import android.graphics.Color;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Toast;

import com.tsorrow.junior.senior.adapter.ImagePagerAdapater;
import com.tsorrow.junior.senior.bean.GoodsInfo;

import java.util.ArrayList;

public class PagerTitleStripActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    private ArrayList<GoodsInfo> goodsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_title_strip);
        PagerTitleStrip pts_title = (PagerTitleStrip) findViewById(R.id.pts_title);
        pts_title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        pts_title.setTextColor(Color.BLUE);

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
