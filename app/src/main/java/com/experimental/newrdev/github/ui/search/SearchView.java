package com.experimental.newrdev.github.ui.search;

import com.experimental.newrdev.github.models.User;

/**
 * Created by newrdev on 7/1/15.
 */
public interface SearchView {
    void navigateToUserActivity(User user);
    void noUserFound();
}
