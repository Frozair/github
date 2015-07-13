package com.experimental.newrdev.github.ui.user;

import com.experimental.newrdev.github.services.GithubService;

/**
 * Created by newrdev on 7/12/15.
 */
public class UserPresenterImpl implements UserPresenter {
    private GithubService service;
    private UserView view;

    public UserPresenterImpl(UserView view, GithubService service){
        this.view = view;
        this.service = service;
    }

    @Override
    public void getRepos() {

    }

    @Override
    public void getsGists() {

    }
}
