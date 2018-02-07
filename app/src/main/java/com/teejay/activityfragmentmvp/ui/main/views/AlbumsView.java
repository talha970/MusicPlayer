package com.teejay.activityfragmentmvp.ui.main.views;

import com.teejay.activityfragmentmvp.data.model.Album;
import com.teejay.activityfragmentmvp.data.model.Artist;

import java.util.List;

/**
 * Created by tjaved on 2/2/18.
 */

public interface AlbumsView {

    public void loadDetailsFragment();
    void showAlbumsEmpty();
    void showAlbums(List<Album> albums);
}
