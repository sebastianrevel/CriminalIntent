package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        //setting up fragment manager
        FragmentManager fm = getSupportFragmentManager();
        //now we will pass it a fragment to manage
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        //we check for this because sometimes fragments are saved when onDestroy is called so it
        //allows us to just recreate what we had before, but in other cases the fragment is null
        //in which case we'd would create one from scratch.
        if (fragment == null) {
            //establishes new fragment
            fragment = createFragment();
            // fragment transactions are used to add, remove, attach, detach, or replace fragments.
            fm.beginTransaction()
                    //adds our new fragment to the container layout
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

    }
}
