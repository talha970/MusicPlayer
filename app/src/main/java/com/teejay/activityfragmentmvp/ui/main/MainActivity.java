package com.teejay.activityfragmentmvp.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.teejay.activityfragmentmvp.AppModule;
import com.teejay.activityfragmentmvp.R;
import com.teejay.activityfragmentmvp.ui.common.BaseActivity;
import com.teejay.activityfragmentmvp.ui.main.presenters.MainPresenterImpl;
import com.teejay.activityfragmentmvp.ui.main.views.MainView;

import android.support.design.widget.BottomNavigationView;

import javax.inject.Inject;


public class MainActivity extends BaseActivity implements MainView, FragmentCallback, BottomNavigationView.OnNavigationItemSelectedListener {

    @Inject
    MainPresenterImpl presenter;

    BottomNavigationView navigation;

    private MainComponent mainComponent;

    public MainComponent getActivityComponent() {
        if (mainComponent == null) {
            mainComponent = DaggerMainComponent.builder()
                    .appModule(new AppModule(getApplication()))
                    .mainModule(new MainModule(this))
                    .build();
        }
        return mainComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load ArtistsFragment
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, ArtistsFragment.newInstance()).commit();


        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);


        getActivityComponent().inject(this);

    }


    /**
     * FragmentCallback implementation
     */
    @Override
    public void loadDetailFragment() {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, SongsFragment.newInstance()).commit();
    }

    @Override
    public void finishProcess() {
        finish();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                presenter.getArtistFragment();
                return true;
            case R.id.navigation_dashboard:
                presenter.getSongsFragment();
                return true;
            case R.id.navigation_notifications:
                presenter.getArtistFragment();
                return true;
        }
        return false;
    }

    @Override
    public void showAlbumFragment() {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, ArtistsFragment.newInstance()).commit();
    }

    @Override
    public void showSongsFragment() {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, SongsFragment.newInstance()).commit();
    }

    @Override
    public void showArtistsFragment() {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, ArtistsFragment.newInstance()).commit();
    }


    @Override
    public void OnPermissionDenied() {
        finish();
    }
}
