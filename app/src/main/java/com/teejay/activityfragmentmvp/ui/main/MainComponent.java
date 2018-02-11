package com.teejay.activityfragmentmvp.ui.main;

import com.teejay.activityfragmentmvp.AppModule;
import com.teejay.activityfragmentmvp.ui.main.activity.MainActivity;
import com.teejay.activityfragmentmvp.ui.main.fragments.*;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tjaved on 1/30/18.
 */
@Singleton
@Component(modules = {MainModule.class, AppModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);

    void inject(ArtistsFragment artistsFragment);

    void inject(SongsFragment songsFragment);

    void inject(AlbumsFragment albumsFragment);

    void inject(AlbumDetailFragment albumDetailFragment);

}
