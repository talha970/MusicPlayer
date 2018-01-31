package com.teejay.activityfragmentmvp.ui.main.presenters;


import com.teejay.activityfragmentmvp.ui.main.views.SongsView;

import javax.inject.Inject;

public class SongsPresenterImpl implements SongsPresenter {
    private SongsView view;


    @Inject
    public SongsPresenterImpl() {
    }

    @Override
    public void getDetails() {
        String details = "Details from some database or something";
        view.showDetails(details);
    }

    @Override
    public void doStuffThenFinish() {
        view.finish();
    }

    @Override
    public void init(SongsView view) {
        this.view=view;
    }
}
