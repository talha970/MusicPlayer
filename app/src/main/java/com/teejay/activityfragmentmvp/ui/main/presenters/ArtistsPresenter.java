package com.teejay.activityfragmentmvp.ui.main.presenters;


import com.teejay.activityfragmentmvp.ui.common.BaseFragmentPresenter;
import com.teejay.activityfragmentmvp.ui.main.views.ArtistsView;

public interface ArtistsPresenter extends BaseFragmentPresenter<ArtistsView> {

    public void getDetails();
    void getStoragePermissions();
    void loadArtists();

}
