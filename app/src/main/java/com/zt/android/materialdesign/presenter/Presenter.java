package com.zt.android.materialdesign.presenter;

import android.support.v4.view.*;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Tony on 16/10/27.
 */

public class Presenter {
//    public void initData(RecyclerView.Adapter adapter,){
//
//    }
    public void setRecycView(RecyclerView recycView,RecyclerView.Adapter adapter){
        recycView.setAdapter(adapter);
    }
    public void setViewPager(ViewPager viewPager,PagerAdapter pagerAdapter){
        viewPager.setAdapter(pagerAdapter);
    }
}
