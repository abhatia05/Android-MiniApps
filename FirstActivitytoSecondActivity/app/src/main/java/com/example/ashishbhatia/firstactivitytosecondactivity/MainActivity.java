package com.example.ashishbhatia.firstactivitytosecondactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    // To call second activity we use Intent. First we create new Intent and than we startActivity by calling start activity.
    public void SecondActivityClick(View view) {
        Intent in = new Intent(this,SecondActivity.class);
        startActivity(in);

    }
}
