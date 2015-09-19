package com.starkhorn.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    private static final String EXTRA_CRIME_ID = "com.starkhorn.criminalintent.crime_id";

    @Override
    protected Fragment createFragment() {
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);

        return CrimeFragment.newInstance(crimeId);
    }

    public static Intent newIntent(Context context, UUID id) {
        Intent intent = new Intent(context, CrimeActivity.class);
        intent.putExtra(CrimeActivity.EXTRA_CRIME_ID, id);

        return intent;
    }
}