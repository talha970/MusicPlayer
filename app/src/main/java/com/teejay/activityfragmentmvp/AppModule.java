package com.teejay.activityfragmentmvp;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Context context;

    public AppModule(Application app) {
        this.context = app;
    }


    @Provides
    @Singleton
    Context provideApplicationContext() {
        return context;
    }
}
