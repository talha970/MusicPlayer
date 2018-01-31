package com.teejay.activityfragmentmvp.ui.main.presenters;


import com.teejay.activityfragmentmvp.ui.common.BaseFragmentPresenter;
import com.teejay.activityfragmentmvp.ui.main.views.SongsView;

public interface SongsPresenter extends BaseFragmentPresenter<SongsView> {

    public void getDetails();
    public void doStuffThenFinish();

}
