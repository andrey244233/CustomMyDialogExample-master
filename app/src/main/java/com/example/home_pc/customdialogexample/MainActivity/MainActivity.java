package com.example.home_pc.customdialogexample.MainActivity;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;


import com.example.home_pc.customdialogexample.Fragments.FragmentWithCustomDialog;
import com.example.home_pc.customdialogexample.Fragments.RecyclerViewFragment;
import com.example.home_pc.customdialogexample.R;
import com.github.florent37.bubbletab.BubbleTab;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcon();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentWithCustomDialog(), "Dialog Fragment");
        adapter.addFragment(new RecyclerViewFragment(), "RecyclerView Fragment");
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcon() {
        TextView tabDIalog = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabDIalog.setText("Show Dialog");
        tabDIalog.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_android_black_24dp, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabDIalog);

        TextView tabRecyclerView = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabRecyclerView.setText("Recycler View");
        tabRecyclerView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_directions_walk_black_24dp, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabRecyclerView);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
           return  mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
    }
}
