package com.teejay.activityfragmentmvp.ui.main.views;

import com.teejay.activityfragmentmvp.data.model.Album;
import com.teejay.activityfragmentmvp.data.model.Song;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by tjaved on 2/7/18.
 */

public interface AlbumDetailsView {

    void showAlbumDetailEmpty();
    void showAlbumDetail(Album album,List<Song> songs);
}
