package com.teejay.activityfragmentmvp.ui.main.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.view.MenuItem;
import com.teejay.activityfragmentmvp.ui.main.fragments.*;
import com.teejay.activityfragmentmvp.AppModule;
import com.teejay.activityfragmentmvp.R;
import com.teejay.activityfragmentmvp.ui.common.BaseActivity;
import com.teejay.activityfragmentmvp.ui.main.DaggerMainComponent;
import com.teejay.activityfragmentmvp.ui.main.FragmentCallback;
import com.teejay.activityfragmentmvp.ui.main.MainComponent;
import com.teejay.activityfragmentmvp.ui.main.MainModule;
import com.teejay.activityfragmentmvp.ui.main.presenters.MainPresenterImpl;
import com.teejay.activityfragmentmvp.ui.main.views.MainView;

import android.support.design.widget.BottomNavigationView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import javax.inject.Inject;


public class MainActivity extends BaseActivity implements MainView,
        FragmentCallback,
        BottomNavigationView.OnNavigationItemSelectedListener {

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

        final FrameLayout mPlayerCollapsed = (FrameLayout) findViewById(R.id.player_col);
        final FrameLayout mPlayerExpanded = (FrameLayout) findViewById(R.id.player_exp);

        LinearLayout mBottomSheet = (LinearLayout) findViewById(R.id.bottom_sheet);

        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(mBottomSheet);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_EXPANDED:{
                        mPlayerCollapsed.setVisibility(View.GONE);
                        mPlayerExpanded.setVisibility(View.VISIBLE);
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED:{
                        mPlayerCollapsed.setVisibility(View.VISIBLE);
                        mPlayerExpanded.setVisibility(View.GONE);}
                    break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

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
                presenter.getAlbumFragment();
                return true;
        }
        return false;
    }

    @Override
    public void showAlbumFragment() {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, AlbumsFragment.newInstance()).commit();
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
