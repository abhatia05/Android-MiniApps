package com.example.ashishbhatia.entertextanddisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClickDisplay(View view) {

        et = (EditText) findViewById(R.id.enterText);
        tv = (TextView) findViewById(R.id.result);
        tv.setText(et.getText());

    }
}
