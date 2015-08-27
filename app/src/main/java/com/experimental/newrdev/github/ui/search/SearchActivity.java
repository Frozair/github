package com.experimental.newrdev.github.ui.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.experimental.newrdev.github.App;
import com.experimental.newrdev.github.AppComponent;
import com.experimental.newrdev.github.R;
import com.experimental.newrdev.github.models.User;
import com.experimental.newrdev.github.ui.common.BaseActivity;
import com.experimental.newrdev.github.ui.user.UserActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by newrdev on 7/1/15.
 */
public class SearchActivity extends BaseActivity implements SearchView, View.OnClickListener{

    @Inject
    SearchPresenter presenter;

    @Bind(R.id.searchText)
    EditText searchText;

    @Bind(R.id.searchButton)
    Button searchButton;

    @Override
    protected void setupComponent(AppComponent component){
        DaggerSearchComponent.builder()
                .appComponent(component)
                .searchModule(new SearchModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void setupView(){
        setContentView(R.layout.search_activity);

        ButterKnife.bind(this);

        searchButton.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        this.setTitle("Github");
    }

    @Override
    public void navigateToUserActivity(User user) {
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }

    @Override
    public void noUserFound() {
        Toast.makeText(this,
                getUsername() + " was not found. The search is case sensitive!",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if(!getUsername().isEmpty()) {
            presenter.search(getUsername());
            hideKeyboard(v);
        }
    }

    private String getUsername(){
        return searchText.getText().toString().trim();
    }

    private void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager)  this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
