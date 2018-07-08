package com.bignerdranch.android.criminalintent;

import android.util.Log;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mID;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime() {
        Log.d("TEST", "InCrime()");
        mID = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mID;
    }

    public String getTitle() {

        return mTitle;
    }

    public Date getDate() {

        return mDate;
    }


    public void setDate(Date date) {

        mDate = date;
    }

    public void setTitle(String title) {

        mTitle = title;
    }

    public boolean isSolved() {

        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

}


