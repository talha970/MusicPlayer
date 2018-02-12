package com.teejay.activityfragmentmvp.ui.main.presenters;

import com.google.gson.Gson;
import com.teejay.activityfragmentmvp.data.DataManager;
import com.teejay.activityfragmentmvp.data.model.Album;
import com.teejay.activityfragmentmvp.data.model.Song;
import com.teejay.activityfragmentmvp.ui.main.views.AlbumDetailsView;

import java.util.List;

import javax.inject.Inject;

import static com.teejay.activityfragmentmvp.ui.main.fragments.AlbumsFragment.ALBUM_ID;

/**
 * Created by tjaved on 2/7/18.
 */

public class AlbumDetailsPresenterImpl implements AlbumDetailsPresenter {
    private AlbumDetailsView view;

    DataManager dataManager;

    @Inject
    public AlbumDetailsPresenterImpl(DataManager dataManager) {
        this.dataManager=dataManager;
    }

    @Override
    public void loadAlbumDetails(String albumBundle) {
        Album album = new Gson().fromJson(albumBundle, Album.class);
        List<Song> songs=dataManager.getSongsByAlbum(album.getId());
        view.showAlbumDetail(album,songs);

    }

    @Override
    public void init(AlbumDetailsView view) {
        this.view=view;
    }
}
