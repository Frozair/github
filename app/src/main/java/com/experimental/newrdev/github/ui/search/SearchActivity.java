package com.experimental.newrdev.github.ui.search;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.experimental.newrdev.github.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by newrdev on 7/1/15.
 */
public class SearchActivity extends Activity implements SearchView, View.OnClickListener{

    @Bind(R.id.searchText)
    EditText searchText;

    @Bind(R.id.searchButton)
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        searchButton.setOnClickListener(this);

        ButterKnife.bind(this);
    }

    @Override
    public void navigateToUserActivity() {

    }

    @Override
    public void noUserFound() {

    }

    @Override
    public void onClick(View v) {

    }
}
