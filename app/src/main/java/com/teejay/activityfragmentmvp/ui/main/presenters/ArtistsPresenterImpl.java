package com.teejay.activityfragmentmvp.ui.main.presenters;


import com.gun0912.tedpermission.PermissionListener;
import com.teejay.activityfragmentmvp.ui.main.views.ArtistsView;
import com.teejay.activityfragmentmvp.util.PermissionManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ArtistsPresenterImpl implements ArtistsPresenter,PermissionListener {
    private ArtistsView view;
    @Inject
    PermissionManager permissionManager;
    private boolean permissionGranted;
    List artists;
    @Inject
    public ArtistsPresenterImpl() {

    }

    @Override
    public void init(ArtistsView view) {
        this.view = view;
        getStoragePermissions();
    }


    @Override
    public void getDetails() {
        // Do stuff to get details
        // then report back to view
        view.loadDetailsFragment();
    }

    @Override
    public void getStoragePermissions() {
        permissionManager.askForStoragePermissions(this);
    }

    @Override
    public void loadArtists() {
        if(!permissionGranted){
            view.showArtistsEmpty();

        }
        else{
            artists= new ArrayList();
            view.showArtists(artists);
        }
    }

    @Override
    public void onPermissionGranted() {
        permissionGranted=true;
        view.showArtists(artists);
    }

    @Override
    public void onPermissionDenied(ArrayList<String> deniedPermissions) {

    }
}
