package com.mac.ben.carlendar1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class StoreActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_tabbed);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.pager);
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());

        adapter.AddFragment(new FragmentStore(), "Some items");
        adapter.AddFragment(new FragmentStore(), "Parts");
        adapter.AddFragment(new FragmentStore(), "Life Saver!");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.warning);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.brake_pad_warning_symbol_in_orange);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setIcon(R.drawable.car_key_symbol_in_green);

    }


}
