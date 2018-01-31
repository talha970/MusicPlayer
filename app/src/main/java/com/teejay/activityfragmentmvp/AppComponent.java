package com.teejay.activityfragmentmvp;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tjaved on 1/30/18.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(App app);
}

