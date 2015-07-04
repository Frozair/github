package com.experimental.newrdev.github.models;

/**
 * Created by newrdev on 7/4/15.
 */
public class User {
    String avatar_url;
    int public_repos;

    public String getAvatarUrl() {
        return avatar_url;
    }

    public int getPublicRepos() {
        return public_repos;
    }
}
