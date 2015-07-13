package com.experimental.newrdev.github.ui.user;

import com.experimental.newrdev.github.services.GithubService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by newrdev on 7/5/15.
 */
@Module
public class UserModule {

    private UserView view;

    public UserModule(UserView view){
        this.view = view;
    }

    @Provides
    public UserView provideView(){
        return view;
    }

    @Provides
    public UserPresenter providePresenter(UserView view, GithubService service){
        return new UserPresenterImpl(view, service);
    }
}
