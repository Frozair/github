package com.experimental.newrdev.github.services;

import com.experimental.newrdev.github.models.User;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by newrdev on 7/4/15.
 */
public interface GithubService {
    @GET("/users/{username}")
    Observable<User> getUser(@Path("username") String username);
}
