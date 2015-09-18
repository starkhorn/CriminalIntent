package com.starkhorn.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by starkhorn on 9/18/2015.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
