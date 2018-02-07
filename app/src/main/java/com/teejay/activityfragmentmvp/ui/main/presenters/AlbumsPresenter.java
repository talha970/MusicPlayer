package com.teejay.activityfragmentmvp.ui.main.presenters;


import com.teejay.activityfragmentmvp.ui.common.BaseFragmentPresenter;
import com.teejay.activityfragmentmvp.ui.main.views.AlbumsView;
import com.teejay.activityfragmentmvp.ui.main.views.ArtistsView;

public interface AlbumsPresenter extends BaseFragmentPresenter<AlbumsView> {

    public void getDetails();
    void getStoragePermissions();
    void loadAlbums();

}
