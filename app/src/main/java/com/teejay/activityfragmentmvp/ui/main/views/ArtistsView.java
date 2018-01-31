package com.teejay.activityfragmentmvp.ui.main.views;


import java.util.List;

public interface ArtistsView {

    public void loadDetailsFragment();
    void showArtistsEmpty();
    void showArtists(List artists);
}
