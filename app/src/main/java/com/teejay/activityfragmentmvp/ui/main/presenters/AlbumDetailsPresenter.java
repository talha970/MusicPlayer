package com.teejay.activityfragmentmvp.ui.main.presenters;

import com.teejay.activityfragmentmvp.ui.common.BaseFragmentPresenter;
import com.teejay.activityfragmentmvp.ui.main.views.AlbumDetailsView;
import com.teejay.activityfragmentmvp.ui.main.views.AlbumsView;

/**
 * Created by tjaved on 2/7/18.
 */

public interface AlbumDetailsPresenter extends BaseFragmentPresenter<AlbumDetailsView> {

    void loadAlbumDetails(String id);


}
