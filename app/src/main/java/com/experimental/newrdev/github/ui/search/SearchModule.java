package com.experimental.newrdev.github.ui.search;

import com.experimental.newrdev.github.services.GithubService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by newrdev on 7/4/15.
 */
@Module
public class SearchModule {

    private SearchView view;

    public SearchModule(SearchView view){
        this.view = view;
    }

    @Provides
    public SearchView provideSearchView(){
        return view;
    }

    @Provides
    public SearchPresenter providePresenter(SearchView view, GithubService githubService){
        return new SearchPresenterImpl(view, githubService);
    }
}
