package com.teejay.activityfragmentmvp.ui.main.presenters;

import com.gun0912.tedpermission.PermissionListener;
import com.teejay.activityfragmentmvp.data.DataManager;
import com.teejay.activityfragmentmvp.data.model.Album;
import com.teejay.activityfragmentmvp.ui.main.views.AlbumsView;
import com.teejay.activityfragmentmvp.util.PermissionManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by tjaved on 2/2/18.
 */

public class AlbumsPresenterImpl implements AlbumsPresenter,PermissionListener {
    private AlbumsView view;
    @Inject
    PermissionManager permissionManager;

    @Inject
    DataManager dataManager;

    private boolean permissionGranted;
    List<Album> Albums;
    @Inject
    public AlbumsPresenterImpl() {

    }

    @Override
    public void init(AlbumsView view) {
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
    public void loadAlbums() {

    }

    @Override
    public void onPermissionGranted() {
        permissionGranted=true;
        Albums= dataManager.getAlbumsfromDevice();
        view.showAlbums(Albums);
    }

    @Override
    public void onPermissionDenied(ArrayList<String> deniedPermissions) {
        view.showAlbumsEmpty();

    }
}