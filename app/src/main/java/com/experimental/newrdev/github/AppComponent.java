package com.experimental.newrdev.github;

import com.experimental.newrdev.github.services.GithubService;
import com.experimental.newrdev.github.services.ServicesModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by newrdev on 7/4/15.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                ServicesModule.class
        }
)
public interface AppComponent {
    void inject(App app);

    GithubService getGithubService();
}
