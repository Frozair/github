package com.experimental.newrdev.github.ui.user;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.experimental.newrdev.github.models.User;

/**
 * Created by newrdev on 7/5/15.
 */
public class UserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        User user = (User) getIntent().getExtras().get("user");
        Toast.makeText(this, "User url: " + user.getAvatarUrl(), Toast.LENGTH_LONG).show();
    }
}
