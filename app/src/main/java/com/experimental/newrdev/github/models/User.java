package com.experimental.newrdev.github.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by newrdev on 7/4/15.
 */
public class User implements Parcelable{
    String avatar_url;
    int public_repos;

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
    }
}
