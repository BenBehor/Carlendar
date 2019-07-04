package com.mac.ben.carlendar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public class DashboardLightActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPageAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardlight);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.pager);
        adapter = new ViewPageAdapter(getSupportFragmentManager());

        adapter.AddFragment(new FragmentRed(), "Red");
        adapter.AddFragment(new FragmentYellow(), "Yellow");
        adapter.AddFragment(new FragmentGreen(), "Green");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.warning);
        tabLayout.getTabAt(1).setIcon(R.drawable.brake_pad_warning_symbol_in_orange);
        tabLayout.getTabAt(2).setIcon(R.drawable.car_key_symbol_in_green);

    }


}
