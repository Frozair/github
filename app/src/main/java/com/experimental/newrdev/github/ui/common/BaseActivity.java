package com.experimental.newrdev.github.ui.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.experimental.newrdev.github.App;
import com.experimental.newrdev.github.AppComponent;

/**
 * Created by newrdev on 7/6/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent((AppComponent) App.get(this).component());
        setupView();
    }

    protected abstract void setupComponent(AppComponent component);

    protected abstract void setupView();
}
