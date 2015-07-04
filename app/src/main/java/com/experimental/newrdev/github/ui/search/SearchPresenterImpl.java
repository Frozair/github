package com.experimental.newrdev.github.ui.search;

import com.experimental.newrdev.github.models.User;
import com.experimental.newrdev.github.services.GithubService;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by newrdev on 7/4/15.
 */
public class SearchPresenterImpl implements SearchPresenter {
    private SearchView view;
    private GithubService service;

    public SearchPresenterImpl(SearchView view, GithubService service)
    {
        this.view = view;
        this.service = service;
    }

    @Override
    public void search(String username) {
        service
                .getUser(username)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("I am in the onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("I am in the onError");
                    }

                    @Override
                    public void onNext(User user) {
                        System.out.println("I am in the onNext");
                        view.navigateToUserActivity(user);
                    }
                });
    }
}
