package com.experimental.newrdev.github.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by newrdev on 7/4/15.
 */
public class User implements Parcelable{
    String avatar_url;
    int public_repos;
    String login;
    String name;
    String location;
    String created_at;
    int followers;
    int following;

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String memberSince() {
        return created_at;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatar_url;
    }

    public int getPublicRepos() {
        return public_repos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(avatar_url);
        dest.writeInt(public_repos);
        dest.writeString(login);
        dest.writeString(name);
        dest.writeString(location);
        dest.writeString(created_at);
        dest.writeInt(followers);
        dest.writeInt(following);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    private User(Parcel in) {
        avatar_url = in.readString();
        public_repos = in.readInt();
        login = in.readString();
        name = in.readString();
        location = in.readString();
        created_at = in.readString();
        followers = in.readInt();
        following = in.readInt();
    }

    @Override
    public String toString() {
        return "User{" +
                "avatar_url='" + avatar_url + '\'' +
                ", public_repos=" + public_repos +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", created_at='" + created_at + '\'' +
                ", followers=" + followers +
                ", following=" + following +
                '}';
    }
}
