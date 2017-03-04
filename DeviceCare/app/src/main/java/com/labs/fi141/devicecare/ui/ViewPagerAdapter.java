package com.labs.fi141.devicecare.ui;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by eugenius on 3/4/17.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    int tabNumber;
    List<CharSequence> titles;
    List<Fragment> fragments;

    public ViewPagerAdapter(FragmentManager fm, List<CharSequence> titles, List<Fragment> fragments) {
        super(fm);
        this.tabNumber = fragments.size();
        this.titles = titles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {

        if (position < fragments.size()) {
            return fragments.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabNumber;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

}
