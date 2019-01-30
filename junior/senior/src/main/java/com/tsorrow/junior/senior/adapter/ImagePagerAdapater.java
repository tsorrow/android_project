package com.tsorrow.junior.senior.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tsorrow.junior.senior.bean.GoodsInfo;

import java.util.ArrayList;

public class ImagePagerAdapater extends PagerAdapter {
    private Context mContext;
    private ArrayList<ImageView> mViewList = new ArrayList<ImageView>();
    private ArrayList<GoodsInfo> mGoodsInfo = new ArrayList<GoodsInfo>();

    public ImagePagerAdapater(Context context,ArrayList<GoodsInfo> goodsList){
        mContext = context;
        mGoodsInfo = goodsList;
        for(int i=0;i<mGoodsInfo.size();i++){
            ImageView view = new ImageView(mContext);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            view.setImageResource(mGoodsInfo.get(i).pic);
            view.setScaleType(ImageView.ScaleType.FIT_CENTER);
            mViewList.add(view);
        }
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewList.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mGoodsInfo.get(position).name;
    }
}
