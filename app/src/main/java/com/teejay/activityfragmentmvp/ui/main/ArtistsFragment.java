package com.teejay.activityfragmentmvp.ui.main;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teejay.activityfragmentmvp.R;
import com.teejay.activityfragmentmvp.ui.common.BaseFragment;
import com.teejay.activityfragmentmvp.ui.main.presenters.ArtistsPresenterImpl;
import com.teejay.activityfragmentmvp.ui.main.views.ArtistsView;

import java.util.List;

import javax.inject.Inject;

public class ArtistsFragment extends BaseFragment implements ArtistsView {
    @Inject
    ArtistsPresenterImpl presenter;
    private FragmentCallback callback;
    private View view;


    public static ArtistsFragment newInstance() {
        return new ArtistsFragment();
    }

    public ArtistsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainActivity) getActivity()).getActivityComponent().inject(this);
        presenter.init(this);
        presenter.loadArtists();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_artists, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Bit naughty but we know it will work!
        callback = (FragmentCallback) activity;
    }

    /**
     * View implementation
     */
    @Override
    public void loadDetailsFragment() {
        // Ask callback to load details fragment
        callback.loadDetailFragment();
    }

    @Override
    public void showArtistsEmpty() {

    }

    @Override
    public void showArtists(List artists) {

    }

}
