package com.teejay.activityfragmentmvp.ui.main.presenters;

import com.teejay.activityfragmentmvp.data.DataManager;
import com.teejay.activityfragmentmvp.data.model.Album;
import com.teejay.activityfragmentmvp.data.model.Song;
import com.teejay.activityfragmentmvp.ui.main.views.AlbumDetailsView;
import com.teejay.activityfragmentmvp.ui.main.views.AlbumsView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by tjaved on 2/7/18.
 */

public class AlbumDetailsPresenterImpl implements AlbumDetailsPresenter {
    private AlbumDetailsView view;
    @Inject
    DataManager dataManager;

    @Override
    public void loadAlbumDetails(Album album) {
        List<Song> songs=dataManager.getSongsByAlbum(id);
    }

    @Override
    public void init(AlbumDetailsView view) {
        this.view=view;
    }
}
