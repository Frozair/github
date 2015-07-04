package com.experimental.newrdev.github;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by newrdev on 7/4/15.
 */
@Module
public class AppModule {
    private App app;

    public AppModule(App app){
        this.app = app;
    }

    @Provides
    @Singleton
    public App provideApplication(){
        return app;
    }
}
