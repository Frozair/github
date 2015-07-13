package com.experimental.newrdev.github.ui.user;

import com.experimental.newrdev.github.ActivityScope;
import com.experimental.newrdev.github.AppComponent;

import dagger.Component;

/**
 * Created by newrdev on 7/5/15.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = UserModule.class
)
public interface UserComponent {
    void inject(UserActivity activity);

    UserPresenter getUserPresenter();
}
