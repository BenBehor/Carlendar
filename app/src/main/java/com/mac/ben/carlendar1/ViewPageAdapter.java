package com.mac.ben.carlendar1;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class ViewPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> lstFragment = new ArrayList<>();
    private final List<String> lstTitles = new ArrayList<>();

    ViewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return lstFragment.get(i);
    }

    @Override
    public int getCount() {
        return lstTitles.size();
    }

    void AddFragment(Fragment fragment, String title){
        lstFragment.add(fragment);
        lstTitles.add(title);
    }
}
