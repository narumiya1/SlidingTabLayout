package com.eijun.slidingtabs;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import com.eijun.slidingtabs.Fragment.FragmentFIve;
import com.eijun.slidingtabs.Fragment.FragmentFour;
import com.eijun.slidingtabs.Fragment.FragmentOne;
import com.eijun.slidingtabs.Fragment.FragmentSix;
import com.eijun.slidingtabs.Fragment.FragmentThree;
import com.eijun.slidingtabs.Fragment.FragmentTwo;
import com.eijun.slidingtabs.adapter.TabAdapter;

public class MainActivity extends AppCompatActivity {

    private  TabAdapter tabAdapter ;
    private TabLayout tabLayout ;
    private Toolbar toolbar ;
    private ViewPager viewPager ;


    private int[] tabsIcon = {
            R.drawable.ic_home_black_24dp ,
            R.drawable.ic_notifications_black_24dp,
            R.drawable.ic_message_black_24dp,
            R.drawable.ic_person_black_24dp,
            R.drawable.ic_phone_black_24dp,
            R.drawable.ic_settings_black_24dp

    } ;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.main_toolbar) ;
        tabLayout = findViewById(R.id.tablayout) ;
        viewPager = findViewById(R.id.viewPager) ;
        setSupportActionBar(toolbar);

        tabAdapter = new TabAdapter(getSupportFragmentManager()) ;
        tabAdapter.addFragment(new FragmentOne(), "Tab 1");
        tabAdapter.addFragment(new FragmentTwo(), "Tab 2");
        tabAdapter.addFragment(new FragmentThree(), "Tab 3");
        tabAdapter.addFragment(new FragmentFour(), "Tab 4");
        tabAdapter.addFragment(new FragmentFIve(), "Tab 5");
        tabAdapter.addFragment(new FragmentSix(), "Tab 6");

        viewPager.setAdapter(tabAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(tabsIcon[0]) ;
        tabLayout.getTabAt(1).setIcon(tabsIcon[1]) ;
        tabLayout.getTabAt(2).setIcon(tabsIcon[2]);
        tabLayout.getTabAt(3).setIcon(tabsIcon[3]);
        tabLayout.getTabAt(4).setIcon(tabsIcon[4]);
        tabLayout.getTabAt(5).setIcon(tabsIcon[5]);

        ColorStateList colorStateList ;
        if (Build.VERSION.SDK_INT >= 23) {
            colorStateList = getResources().getColorStateList(R.drawable.tab_icon,getTheme()) ;

        }else {
            colorStateList = getResources().getColorStateList(R.drawable.tab_icon) ;
        }

        for (int i = 0 ; i < tabLayout.getTabCount() ; i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i) ;
            Drawable icon = tab.getIcon();

            if (icon != null){
                icon = DrawableCompat.wrap(icon) ;
                DrawableCompat.setTintList(icon, colorStateList);
            }
        }
    }
}