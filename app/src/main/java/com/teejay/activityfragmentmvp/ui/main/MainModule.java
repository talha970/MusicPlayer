package com.teejay.activityfragmentmvp.ui.main;

import android.content.Context;

import com.teejay.activityfragmentmvp.data.DataManager;
import com.teejay.activityfragmentmvp.ui.main.activity.MainActivity;
import com.teejay.activityfragmentmvp.ui.main.presenters.AlbumDetailsPresenter;
import com.teejay.activityfragmentmvp.ui.main.presenters.AlbumDetailsPresenterImpl;
import com.teejay.activityfragmentmvp.ui.main.presenters.AlbumsPresenter;
import com.teejay.activityfragmentmvp.ui.main.presenters.AlbumsPresenterImpl;
import com.teejay.activityfragmentmvp.ui.main.presenters.SongsPresenter;
import com.teejay.activityfragmentmvp.ui.main.presenters.SongsPresenterImpl;
import com.teejay.activityfragmentmvp.ui.main.presenters.ArtistsPresenter;
import com.teejay.activityfragmentmvp.ui.main.presenters.ArtistsPresenterImpl;
import com.teejay.activityfragmentmvp.ui.main.presenters.MainPresenter;
import com.teejay.activityfragmentmvp.ui.main.presenters.MainPresenterImpl;
import com.teejay.activityfragmentmvp.ui.main.views.MainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private MainActivity activity;

    public MainModule(MainActivity activity) {
        this.activity = activity;
    }

    /**
     * Provide MainView
     */
    @Provides
    @Singleton
    public MainView provideMainView() {
        return (MainView) activity;
    }

    /**
     * Provide MainPresenter
     */
    @Provides
    @Singleton
    public MainPresenter provideMainPresenter(MainView view) {
        return new MainPresenterImpl(view);
    }

    /**
     * Provide ArtistsPresenter
     */
    @Provides
    @Singleton
    public ArtistsPresenter provideIntroPresenter() {
        return new ArtistsPresenterImpl();
    }


    /**
     * Provide SongsPresenter
     */
    @Provides
    @Singleton
    public AlbumsPresenter provideAlbumsPresenter(DataManager dataManager) {
        return new AlbumsPresenterImpl(dataManager);
    }
    @Provides
    @Singleton
    public SongsPresenter provideDetailsPresenter() {
        return new SongsPresenterImpl();
    }

    @Provides
    @Singleton
    public AlbumDetailsPresenter provideAlbumDetailsPresenter(DataManager dataManager) {
        return new AlbumDetailsPresenterImpl(dataManager);
    }

    @Provides
    @Singleton
    public DataManager provideDataManager(Context context){
        return new DataManager(context);
    }

}
