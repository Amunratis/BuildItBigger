package com.example.justjoking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJoke extends AppCompatActivity {

    public static final String JOKE_EXTRA ="com.example.justjoking.JOKE_EXTRA";
    private TextView jokeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_joke);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);*/

   /*     fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        jokeTv = findViewById(R.id.jokefield);
        handleIntent();
    }



    private void handleIntent() {
        Bundle bundle = getIntent().getExtras();
        String joke = obtainJoke(bundle, getString(R.string.joke_activity_no_joke));
        jokeTv.setText(joke);
    }

    private String obtainJoke(Bundle bundle, String defaultJoke) {
        if (bundle == null) return defaultJoke;
        return bundle.getString(JOKE_EXTRA, defaultJoke);
    }
}
