package com.experimental.newrdev.github.ui.user;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.experimental.newrdev.github.AppComponent;
import com.experimental.newrdev.github.R;
import com.experimental.newrdev.github.models.User;
import com.experimental.newrdev.github.ui.common.BaseActivity;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by newrdev on 7/5/15.
 */
public class UserActivity extends BaseActivity implements UserView{

    private User user;

    @Inject
    UserPresenter presenter;

    @Bind(R.id.card)
    CardView card;
    @Bind(R.id.roundImage)
    RoundImageView imageView;
    @Bind(R.id.username)
    TextView username;
    @Bind(R.id.location)
    TextView location;
    @Bind(R.id.followers)
    TextView followers;
    @Bind(R.id.following)
    TextView following;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.user = (User) getIntent().getExtras().get("user");

        setupUserInfo();
    }

    @Override
    protected void setupComponent(AppComponent component){
        DaggerUserComponent.builder()
                .appComponent(component)
                .userModule(new UserModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void setupView(){
        setContentView(R.layout.user_activity);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }

        this.setTitle("User Info");
    }

    private void setupUserInfo(){
        Picasso.with(this)
                .load(user.getAvatarUrl())
                .placeholder(R.drawable.icon_user)
                .into(imageView);
        card.setBackgroundColor(getResources().getColor(R.color.background_material_dark));

        String userText = (user.getName().isEmpty() ? user.getLogin() : user.getName()).toUpperCase();
        username.setText(userText);

        location.setText(user.getLocation());

        followers.setText(String.valueOf(user.getFollowers()));
        following.setText(String.valueOf(user.getFollowing()));
    }
}
