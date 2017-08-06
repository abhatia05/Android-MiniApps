package com.example.ashishbhatia.basicfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ashishbhatia on 06/08/17.
 */

public class Fragment2 extends Fragment {
    @Nullable
    @Override
    //LayoutInflater is used to create a new View (or layout) object from one of your xml layouts.

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2, container, false);
    }
}
