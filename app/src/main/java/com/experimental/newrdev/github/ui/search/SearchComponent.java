package com.experimental.newrdev.github.ui.search;

import com.experimental.newrdev.github.ActivityScope;
import com.experimental.newrdev.github.AppComponent;
import dagger.Component;

/**
 * Created by newrdev on 7/4/15.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = SearchModule.class
)
public interface SearchComponent {
    void inject(SearchActivity searchActivity);

    SearchPresenter getSearchPresenter();
}
