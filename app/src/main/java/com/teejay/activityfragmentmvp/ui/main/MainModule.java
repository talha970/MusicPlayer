package com.teejay.activityfragmentmvp.ui.main;

import com.teejay.activityfragmentmvp.ui.main.adapters.ArtistsAdapter;
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
    public SongsPresenter provideDetailsPresenter() {
        return new SongsPresenterImpl();
    }

}
