package com.teejay.activityfragmentmvp.ui.main.fragments;


import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.teejay.activityfragmentmvp.R;
import com.teejay.activityfragmentmvp.data.model.Album;
import com.teejay.activityfragmentmvp.ui.common.BaseFragment;
import com.teejay.activityfragmentmvp.ui.main.FragmentCallback;
import com.teejay.activityfragmentmvp.ui.main.activity.MainActivity;
import com.teejay.activityfragmentmvp.ui.main.adapters.AlbumsAdapter;
import com.teejay.activityfragmentmvp.ui.main.adapters.base.OnRecycleObjectClickListener;
import com.teejay.activityfragmentmvp.ui.main.presenters.AlbumsPresenterImpl;
import com.teejay.activityfragmentmvp.ui.main.views.AlbumsView;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumsFragment extends BaseFragment implements AlbumsView, OnRecycleObjectClickListener<Album> {
    private static final String TAG = "AlbumsFragment";
    public static final String ALBUM_ID ="Album_ID" ;
    @Inject
    AlbumsPresenterImpl presenter;

    @Inject
    AlbumsAdapter albumsAdapter;

    private FragmentCallback callback;

    private View view;

    @BindView(R.id.albums_recycler_view) RecyclerView mRecyclerView;


    public static AlbumsFragment newInstance() {
        return new AlbumsFragment();
    }

    public AlbumsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainActivity) getActivity()).getActivityComponent().inject(this);

        presenter.init(this);
        presenter.loadAlbums();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_albums, container, false);
        ButterKnife.bind(this,view);
        albumsAdapter.setListener(this);
        mRecyclerView.setAdapter(albumsAdapter);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
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
    public void showAlbumsEmpty() {
        albumsAdapter.setItems(Collections.<Album>emptyList());
        albumsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showAlbums(List<Album> Albums) {
        Log.d(TAG, String.valueOf(Albums.size()));
        albumsAdapter.setItems(Albums);
        albumsAdapter.notifyDataSetChanged();

    }

    @Override
    public void OnItemClick(Album item) {
        Bundle bundle= new Bundle();
        bundle.putString(ALBUM_ID,new Gson().toJson(item));

        Fragment detailFragment = new AlbumDetailFragment();

        detailFragment.setArguments(bundle);

       getFragmentManager().
               beginTransaction().
               replace(R.id.fragment_container,detailFragment).
               addToBackStack(null).
               commit();

    }
}
