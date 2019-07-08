package com.youngfeng.snake.util;

import android.app.Fragment;
import android.app.FragmentManager;
import android.view.View;

/**
 * Fragment manager utils
 *
 * @author Scott Smith 2017-12-16 17:34
 */
public class FragmentManagerHelper {
    private FragmentManager mFragmentManager;
    private androidx.fragment.app.FragmentManager mSupportFragmentManager;

    public FragmentManagerHelper(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }

    public FragmentManagerHelper(androidx.fragment.app.FragmentManager fragmentManager) {
        mSupportFragmentManager = fragmentManager;
    }

    public static FragmentManagerHelper get(FragmentManager fragmentManager) {
        return new FragmentManagerHelper(fragmentManager);
    }

    public static FragmentManagerHelper get(androidx.fragment.app.FragmentManager fragmentManager) {
        return new FragmentManagerHelper(fragmentManager);
    }

    public Fragment getLastFragment() {
        int backStackCount = mFragmentManager.getBackStackEntryCount();
        if (backStackCount <= 0) return null;

        FragmentManager.BackStackEntry backStackEntry = mFragmentManager.getBackStackEntryAt(backStackCount - 1);
        String fragmentTag = backStackEntry.getName();
        return mFragmentManager.findFragmentByTag(fragmentTag);
    }

    public androidx.fragment.app.Fragment getLastSupportFragment() {
        int backStackCount = mSupportFragmentManager.getBackStackEntryCount();
        if (backStackCount <= 0) return null;

        androidx.fragment.app.FragmentManager.BackStackEntry backStackEntry = mSupportFragmentManager.getBackStackEntryAt(backStackCount - 1);
        String fragmentTag = backStackEntry.getName();
        return mSupportFragmentManager.findFragmentByTag(fragmentTag);
    }

    public View getViewOfLastFragment() {
        if(null == getLastFragment()) return null;
        return getLastFragment().getView();
    }

    public View getViewOfLastSupportFragment() {
        if (null == getLastSupportFragment()) return null;

        return getLastSupportFragment().getView();
    }

    public boolean backToLastFragment() {
        return mFragmentManager.popBackStackImmediate();
    }

    public boolean backToSupportFragment() {
        return mSupportFragmentManager.popBackStackImmediate();
    }

    public boolean backStackEmpty() {
        return mFragmentManager.getBackStackEntryCount() <= 0;
    }

    public boolean supportBackStackEmpty() {
        return mSupportFragmentManager.getBackStackEntryCount() <= 0;
    }
}
