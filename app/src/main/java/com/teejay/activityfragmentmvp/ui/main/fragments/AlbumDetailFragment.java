package com.teejay.activityfragmentmvp.ui.main.fragments;

import android.app.Fragment;
import android.os.Bundle;


import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.teejay.activityfragmentmvp.R;
import com.teejay.activityfragmentmvp.data.model.Album;
import com.teejay.activityfragmentmvp.data.model.Song;
import com.teejay.activityfragmentmvp.ui.main.activity.MainActivity;
import com.teejay.activityfragmentmvp.ui.main.presenters.AlbumDetailsPresenter;
import com.teejay.activityfragmentmvp.ui.main.presenters.AlbumsPresenterImpl;
import com.teejay.activityfragmentmvp.ui.main.views.AlbumDetailsView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.teejay.activityfragmentmvp.ui.main.fragments.AlbumsFragment.ALBUM_ID;

/**
 * Created by tjaved on 2/5/18.
 */

public class AlbumDetailFragment extends Fragment implements AlbumDetailsView {
    private View view;

    @Inject
    AlbumDetailsPresenter presenter;

    TextView tvAlbumName;

    @BindView(R.id.ivAlbumThumb) ImageView ivAlbumThumb;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MainActivity) getActivity()).getActivityComponent().inject(this);
        String albumBundle=getArguments().getString(ALBUM_ID);
        presenter.init(this);
        presenter.loadAlbumDetails(albumBundle);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.album_detail, container, false);
        tvAlbumName=(TextView)view.findViewById(R.id.tvAlbumName);
                ButterKnife.bind(this,view);
       // albumsAdapter.setListener(this);
       // mRecyclerView.setAdapter(albumsAdapter);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
       // mRecyclerView.setLayoutManager(mLayoutManager);
        return view;
    }


    @Override
    public void showAlbumDetailEmpty() {

    }

    @Override
    public void showAlbumDetail(Album album,List<Song> songs) {
        if(album!=null) {
            tvAlbumName.setText(album.getName());
            String imgPath = album.getThumbnail();
            Picasso.with(getActivity()).load(imgPath != null ? "file://" + imgPath : "http://i.imgur.com/DvpvklR.png").into(ivAlbumThumb);
        }

    }
}
