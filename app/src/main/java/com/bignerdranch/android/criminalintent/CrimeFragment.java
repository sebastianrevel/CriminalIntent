package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

public class CrimeFragment extends Fragment {
    private static final String ARG_CRIME_ID = "crime_id";
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    public static CrimeFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);

        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("TEST", "InCrimeFragment");
        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // we pass on false, because we want to add the view to the activity's code.
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        //sets title field based on user input
        mTitleField = v.findViewById(R.id.crime_title);
        mTitleField.setText(mCrime.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged (CharSequence s, int start, int count, int after) {
                //blank
                }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // sets the title of the crime based on the users input
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //finds the view by id
        mDateButton = v.findViewById(R.id.crime_date);
        // pulls the getDate getter from Crime.java to set as the text of the button
        mDateButton.setText(mCrime.getDate().toString());
        // disabling button removes it from being pressed by user
        mDateButton.setEnabled(false);

        //finding checkbox
        mSolvedCheckBox = v.findViewById(R.id.crime_solved);
        //checks to see if check exists already
        mSolvedCheckBox.setChecked(mCrime.isSolved());
        //creating a listener for the checkbox
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //if the check box ischecked, the crime will be categorized as solved.
                mCrime.setSolved(isChecked);
            }
        });

        return v;
    }

}
