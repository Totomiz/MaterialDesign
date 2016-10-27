package com.zt.android.materialdesign;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.zt.android.materialdesign.adapter.AdapterFactory;
import com.zt.android.materialdesign.adapter.PagerAdapter;
import com.zt.android.materialdesign.adapter.RcycAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "PagerActivity";
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private PagerAdapter mViewAdapter;
    private FloatingActionButton mFab;
    private SimpleAdapter mListAdapter;
    private RcycAdapter mListRcycAdapter;
    private RcycAdapter mGridRcycAdapter;
    private TabLayout mTabLayout;
    private ActionBarDrawerToggle mToggle;

    private void initView() {
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        mToolbar= (Toolbar) findViewById(R.id.tool_bar);
        mViewPager= (ViewPager) findViewById(R.id.viewpager);
        mFab= (FloatingActionButton) findViewById(R.id.fab);
        mTabLayout= (TabLayout) findViewById(R.id.tab_layout);

        mToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(mToggle);

    }

    private void initData() {
        List<View> viewList=new ArrayList<>();
        List<String> titleList=new ArrayList<>();
        View view1= LayoutInflater.from(this).inflate(R.layout.rcyc_layout,null);
        View view2= LayoutInflater.from(this).inflate(R.layout.list_layout,null);
        View view3= LayoutInflater.from(this).inflate(R.layout.rcyc_layout,null);
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        titleList.add("Title1");
        titleList.add("Title2");
        titleList.add("Title3");
        mListRcycAdapter=new RcycAdapter(this, AdapterFactory.generateListString(200));
        mGridRcycAdapter=new RcycAdapter(this, AdapterFactory.generateListString(200));
        mListAdapter=AdapterFactory.generateListStrAdapter(this,AdapterFactory.generateListString(100));
        mViewAdapter=new PagerAdapter(viewList,titleList);
        ((RecyclerView)view1).setLayoutManager(new GridLayoutManager(this,2));
        ((RecyclerView)view1).setAdapter(mListRcycAdapter);
        ((ListView)view2).setAdapter(mListAdapter);
        ((RecyclerView)view3).setLayoutManager(new LinearLayoutManager(this));
        ((RecyclerView)view3).setAdapter(mGridRcycAdapter);
        mViewPager.setAdapter(mViewAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        initView();
        initData();
        setSupportActionBar(mToolbar);
        onAction();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mToggle.syncState();
    }

    //导航栏右上选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mToggle.onOptionsItemSelected(item)) {
            Log.d(TAG, "onOptionsItemSelected: ");
            return true;
        }
        if (mToggle.onOptionsItemSelected(item)) {
            Log.d(TAG, "onOptionsItemSelected: ");
            return true;
        }

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            makeSnake("Action setting select");
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    private void onAction() {
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeSnake("Hello. I am Snackbar!");
            }
        });
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void makeSnake(CharSequence text){
        Snackbar.make(mFab, text, Snackbar.LENGTH_SHORT)
                .setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                })
                .show();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            // Handle the camera action
            makeSnake(item.getTitle());
        } else if (id == R.id.nav_gallery) {
            makeSnake(item.getTitle());
        } else if (id == R.id.nav_slideshow) {
            makeSnake(item.getTitle());
        } else if (id == R.id.nav_manage) {
            makeSnake(item.getTitle());
        } else if (id == R.id.nav_share) {
            makeSnake(item.getTitle());
        } else if (id == R.id.nav_send) {
            makeSnake(item.getTitle());
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
