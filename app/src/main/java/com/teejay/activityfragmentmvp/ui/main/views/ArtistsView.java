package com.teejay.activityfragmentmvp.ui.main.views;


import com.teejay.activityfragmentmvp.data.model.Artist;

import java.util.List;

public interface ArtistsView {

    public void loadDetailsFragment();
    void showArtistsEmpty();
    void showArtists(List<Artist> artists);
}
