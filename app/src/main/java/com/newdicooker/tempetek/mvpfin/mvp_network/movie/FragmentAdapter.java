package com.newdicooker.tempetek.mvpfin.mvp_network.movie;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.newdicooker.tempetek.mvpfin.mvp_network.movie.fragment.OneFragment;
import com.newdicooker.tempetek.mvpfin.mvp_network.movie.fragment.TwoFragment;

/**
 * Created by SPC
 * on 2018/10/18
 * 邮箱：13027699936@163.com.
 * version 2.0.4
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"one", "two"};

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new OneFragment();
        }
        return new TwoFragment();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
