package com.zt.android.materialdesign.adapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Tony on 16/10/27.
 */

public class PagerAdapter extends android.support.v4.view.PagerAdapter {
    private List<String> titleList;
    private List<View> viewList;
    public PagerAdapter(List<View> viewList,List<String> titleList){
        this.viewList=viewList;
        this.titleList=titleList;
    }
    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));//删除页卡
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
