package com.example.ashishbhatia.passingdatainactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void submit(View view) {

        EditText nm = (EditText) findViewById(R.id.enterName);
        EditText ag = (EditText) findViewById(R.id.enterAge);

        Intent pd = new Intent(this,SecondActivity.class);
        pd.putExtra("Name",nm.getText().toString());
        pd.putExtra("Age",ag.getText().toString());

        startActivity(pd);

    }
}
