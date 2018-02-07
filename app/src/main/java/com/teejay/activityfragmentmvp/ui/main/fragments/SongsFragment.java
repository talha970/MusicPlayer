package com.teejay.activityfragmentmvp.ui.main.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.teejay.activityfragmentmvp.R;
import com.teejay.activityfragmentmvp.ui.common.BaseFragment;
import com.teejay.activityfragmentmvp.ui.main.FragmentCallback;
import com.teejay.activityfragmentmvp.ui.main.activity.MainActivity;
import com.teejay.activityfragmentmvp.ui.main.presenters.SongsPresenterImpl;
import com.teejay.activityfragmentmvp.ui.main.views.SongsView;

import javax.inject.Inject;


public class SongsFragment extends BaseFragment implements SongsView {
    @Inject
    SongsPresenterImpl presenter;
    private FragmentCallback callback;
    private View view;
    private Button getDetails, finishThis;
    private TextView detailsText;


    public static SongsFragment newInstance() {
        return new SongsFragment();
    }

    public SongsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainActivity) getActivity()).getActivityComponent().inject(this);
    }


    @Override
    public void onResume() {
        super.onResume();

        presenter.init(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_songs, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        detailsText = (TextView) view.findViewById(R.id.details);

        getDetails = (Button) view.findViewById(R.id.get_details);
        getDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getDetails();
            }
        });

        finishThis = (Button) view.findViewById(R.id.finish);
        finishThis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.doStuffThenFinish();
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callback = (FragmentCallback) activity;
    }


    /**
     * View implementation
     */
    @Override
    public void finish() {
        callback.finishProcess();
    }

    @Override
    public void showDetails(String details) {
        detailsText.setText(details);
    }
}
