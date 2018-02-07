package com.teejay.activityfragmentmvp.ui.main.fragments;

import android.app.Fragment;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tjaved on 2/5/18.
 */

public class AlbumDetailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView=new TextView(getActivity());
        textView.setText("Hello I am fragment C");
        return textView;
    }



}
