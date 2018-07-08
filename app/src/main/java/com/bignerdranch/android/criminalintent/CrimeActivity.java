package com.bignerdranch.android.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {
    private static final String EXTRA_CRIME_ID = "com.bignerdranch.android.criminalintent.crime_id";

    //this will tell CrimeFragment which crime to deploy by passing crime id
    //called when a crime is clicked
    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Log.d("TEST", "InCrimeActivityNewIntent");
        //creates a new intent that will take the next activity to crimeactivity
        Intent intent = new Intent(packageContext, CrimeActivity.class);
        //UUID is serializable.
        //gets crimeid that was passed in CrimeListActivity
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }
    @Override
    protected Fragment createFragment() {
        Log.d("TEST", "InCrimeActivityCreateFragment");
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }
}
