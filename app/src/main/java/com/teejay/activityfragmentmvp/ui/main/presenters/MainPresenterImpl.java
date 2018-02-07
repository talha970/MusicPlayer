package com.teejay.activityfragmentmvp.ui.main.presenters;


import com.teejay.activityfragmentmvp.ui.main.views.MainView;

import javax.inject.Inject;

public class MainPresenterImpl implements MainPresenter {
    private MainView view;



    @Inject
    public MainPresenterImpl(MainView view) {
        this.view = view;
    }

    @Override
    public void getArtistFragment() {
        view.showArtistsFragment();
    }

    @Override
    public void getSongsFragment() {
        view.showSongsFragment();
    }

    @Override
    public void getAlbumFragment() {
        view.showAlbumFragment();
    }

}
