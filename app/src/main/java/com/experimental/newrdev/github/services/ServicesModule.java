package com.experimental.newrdev.github.services;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Created by newrdev on 7/4/15.
 */
@Module
public class ServicesModule {
    @Provides
    @Singleton
    public GithubService provideGithubService(){
        return new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(GithubService.class);
    }
}
