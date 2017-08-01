package com.example.ashishbhatia.passingdatainactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView nm = (TextView) findViewById(R.id.name);
        TextView ag = (TextView) findViewById(R.id.age);

       // Intent rc = new Intent();

        String name = getIntent().getStringExtra("Name");
        String age = getIntent().getStringExtra("Age");

        nm.setText(name);
        ag.setText(age);

    }
}
