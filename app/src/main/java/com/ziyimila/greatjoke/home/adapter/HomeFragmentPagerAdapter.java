package com.ziyimila.greatjoke.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ziyimila.greatjoke.home.view.TextContentJokeFragment;

/**
 * Created by Administrator on 2017/12/18.
 */

public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int COUNT = 3;
    private String[] mTitles = new String[]{"文本","图片","动图"};

    public HomeFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return TextContentJokeFragment.newInstance();
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
